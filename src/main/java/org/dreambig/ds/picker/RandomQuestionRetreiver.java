package org.dreambig.ds.picker;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.concurrent.ThreadLocalRandom;

public class RandomQuestionRetreiver {

    public void findAllClasses( Queue<String> packagesQ, Set<Class> classes) {
        while (!packagesQ.isEmpty()) {
            String packageName = packagesQ.remove();
            InputStream stream = ClassLoader.getSystemClassLoader()
                    .getResourceAsStream(packageName.replaceAll("[.]", "/"));
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            reader.lines().forEach((tkn) -> {
                        if (tkn.endsWith(".class")  && !tkn.contains("$")) {
                            classes.add(getClass(packageName, tkn));
                        } else {
                            if(!tkn.isEmpty() &&!tkn.equals("null") && !tkn.contains("$"))
                                packagesQ.add(packageName + "." + tkn);
                        }
                    }
            );
        }
    }

    private Class getClass( String packageName,String className) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }
    private List<Class> getQuestion(String qt,Set<Class> clazz){
        List<Class>res= new ArrayList<>();
        for(Class cl:clazz){
            if( cl.getCanonicalName().toLowerCase().contains(qt))
                res.add(cl);
        }
        return res;
    }


    private  void retrieve(){
        List<String> result=new ArrayList<>(6);
        // List path in project
        Queue<String> queue= new LinkedList<>();
        Set<Class> classes = new HashSet<>();
        queue.add("org.dreambig.ds");
        findAllClasses(queue,classes);


        List<Class> allEasy = getQuestion("easy",classes);
        List<Class> allMedium = getQuestion("medium",classes);
        List<Class> allHard = getQuestion("hard",classes);
        int easyCnt=0, medCnt=0, hardCnt=0;
        int ctr=1;
        while(easyCnt<3){
            int randomNum = ThreadLocalRandom.current().nextInt(0, allEasy.size());
            String q=invokeMethod(allEasy.get(randomNum));
            if(q!=null){
                System.out.println(ctr+". Ques\n"+q+"\n\n");
                ctr++;
                easyCnt++;
            }

        }
        while(medCnt<2){
            int randomNum = ThreadLocalRandom.current().nextInt(0, allMedium.size());
            String q=invokeMethod(allMedium.get(randomNum));
            if(q!=null){
                System.out.println(ctr+". Ques\n"+q+"\n\n");
                ctr++;
                medCnt++;
            }

        }
        while(hardCnt<1){
            int randomNum = ThreadLocalRandom.current().nextInt(0, allHard.size());
            String q=invokeMethod(allHard.get(randomNum));
            if(q!=null){
                System.out.println(ctr+". Ques\n"+q+"\n\n");
                ctr++;
                hardCnt++;
            }

        }
    }

    private  String invokeMethod(Class clazz){
        try{
            Object t = clazz.newInstance();

            Method m =clazz.getMethod("getQuestion");
            String res=m.invoke(t).toString();
            return  res;
        }catch (Exception e){
            return  null;
        }
    }



    public static void main(String[] args) {
        RandomQuestionRetreiver obj = new RandomQuestionRetreiver();
        obj.retrieve();
    }
}
