namespace cpp com.baeldung.thrift.impl
namespace java generated

exception InvalidOperationException {
    1: i32 code,
    2: string description
}

const i32 MAX_RESULTS = 100;

enum UserType {
    NORMAL,
    ADMIN,
    SUPERUSER
}

struct CrossPlatformResource {
    1: i32 id,
    2: string name,
    3: optional string salutation
    4: required list<string> emails;
    5: optional map<string,string> idAndUserName;
    6: bool isAdmin;
    7: optional set<string> userSet;
    8: optional UserType userType;
}

service CrossPlatformService {

    CrossPlatformResource get(1:i32 id) throws (1:InvalidOperationException e),

    void save(1:CrossPlatformResource resource) throws (1:InvalidOperationException e),

    list <CrossPlatformResource> getList() throws (1:InvalidOperationException e),

    bool ping() throws (1:InvalidOperationException e)
}