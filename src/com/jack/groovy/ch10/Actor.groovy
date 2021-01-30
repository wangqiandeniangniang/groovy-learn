import groovy.ant.AntBuilder
import groovy.transform.TypeChecked

class Actor11{
    String firstName, lastName
    @TypeChecked
    String getFullName() { "$firstName $lastName" }

    void makePeace(){
        new AntBuilder().echo('Peace was never an option')
    }
}

def magneto = new Actor11(firstName: "Ian", lastName: 'MacKellen')
assert magneto.fullName == 'Ian MacKellen'
magneto.makePeace()