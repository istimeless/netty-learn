namespace java com.istimeless.thrift

typedef i16 short
typedef i32 int
typedef i64 long
typedef string String
typedef bool boolean

struct Person {
    1: optional String username,
    2: optional int age
}

exception DataException {
    1: optional String message,
    2: optional String stack,
    3: optional String date
}

service PersonService {
    Person getPersonByUsername(1: required String username) throws (1: optional DataException e),

    void savePerson(1: required Person person) throws (1: optional DataException e)
}