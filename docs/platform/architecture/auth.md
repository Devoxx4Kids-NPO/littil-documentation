#Authentication and authorization WORK IN PROGRESS

## Role and permissions tables

The following table lists the available roles that can be assigned to registered users of the platform

| User | Description |
| ----------- | ----------- |
|teacher|assigned to a registered user who uses the platform as a volunteer teacher |
|school|assigned to the user who is the designated point of contact for a school |
|admin|assigned to a user with complete administrative control. |

## Permissions explained

Authorized users of the platform invoke the REST api to read and write resources from/to the data store.

For non-admin users, not all data records in a single resources (school or teacher) can be accessed/edited with the same permissions.

Each resource has both private and public fields/properties

* private fields can only be viewed and edited by the owner of the record (i.e. of a teacher's or school's own record) or after express permission.
* public fields are available to all users of the system

Teachters can update their own record and see basic details of all other teachers: name, city and materials they teach. 

A school contact can look for other schools and see basic details, like the name and region.
When they search for a teacher, they can find all teachers and see the same public fields that other teachers can see.

Contact details are never part of public data. These are only visible to admins 

If schools and teachers want to get in touch for the first time, they can do so through the LITTIL platform, which will relay the message through email.

### Read permissions for teacher resources

| permission | assigned to roles | comment |
| ---- | ---- | ---- |
| list public teacher data by any search criteria | admin | a search can be unrestricted search and hence return the complete list of teachers|
| look up any teacher's full data by their id | admin |
| a teacher looks up their own complete record | teacher |
| look up basic details of a teacher by id | school, teacher |  |

### Read permissions for school resources

| permission | assigned to roles | comment |
| ---- | ---- | ---- |
| list public school data by any search criteria | school | a search can be unrestricted search and hence return the complete list of schools.|
| look up a school's full data by its id | admin |
| a school contact looks up their school's full record | school |
| a teacher can look up the school that they are connected with full details | teacher |
| a teacher can look up any school with basic details | teacher |


### Write permissions for teacher resource

| permission | assigned to roles | comment |
| ---- | ---- | ---- |
|update the teacher record of the logged-in user|teacher||
|delete the teacher record of the logged-in user|teacher||
|update a teacher record for a random user|admin||
|delete a teacher record for a random user|admin||

### Write permissions for school resource

| permission | assigned to roles | comment |
| ---- | ---- | ---- |
|update the school record of the logged-in user|teacher||
|delete the school record of the logged-in user|teacher||
|update a school record for a random user|admin||
|delete a school record for a random user|admin||
