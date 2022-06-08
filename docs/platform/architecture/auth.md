#Authentication and authorization [WORK IN PROGRESS]

## Role and permissions tables

The following table lists the available roles that can be assigned to registered users of the platform

| User | Description |
| ----------- | ----------- |
|teacher|assigned to an individual teacher|
|school|assigned to the user who is the designated point of contact for a school |
|admin|contains all administrative privileges|


### Permissions for reading

| permission | allowed roles | comment |
| ---- | ---- | ---- |
| list schools by any search criteria | | a search can be unrestricted search and hence return the complete list of schools.|
| look up a random school by its id | |
| look up the school associated with the logged in user | | this can be the designated contact of the school, or a teacher associated with the school.
| list teachers by any search criteria | admin | a search can be unrestricted search and hence return the complete list of teachers|
| look up a random teacher by their id | admin |
| look up a teacher associated with the logged in user | | this can be a school contact looking up a teacher who volunteers for that school, or the teacher accessing their own account data|

### Permissions for writing

| permission | allowed roles | comment |
| ---- | ---- | ---- |
|update the teacher record of the logged in user|teacher||
|delete the teacher record of the logged in user|teacher||
|update a teacher record for a random user|admin||
|delete a teacher record for a random user|admin||
|update the school record of the logged in user|teacher||
|delete the school record of the logged in user|teacher||
|update a school record for a random user|admin||
|delete a school record for a random user|admin||
