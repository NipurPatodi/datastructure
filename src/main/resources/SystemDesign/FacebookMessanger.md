##FB Messenger ##

### Requirement ###
 **Functional**
1. one-one chat (online)
2. Historical data
3. Status of user
4. If user offline , it should be synced when online
5. group chat
6. push down notification


**Non functional**
1. low latency
2. Consistency ( same msg history on all device)
3. HA ( Low Availablity to support consistency)

### Back of the envolepe calculation ###

- total active user 500M and each send 40 message on average\
    total msg per day = 20B
    average msg size = 100byte
    Size per day = ~2 TB per day
    5 year data = 3.56 PB 
    we apply 70-30 rule => 5 PB

- Bandwidth  
    2TB/(24 *3600)=24 MB per sec

### Highlevel design ###

user  -> LB -> APP server <-> DB\
                          -> user\

==> better is in book

