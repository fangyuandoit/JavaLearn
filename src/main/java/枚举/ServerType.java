package 枚举;


/**
 * @program: shodan_breach
 * @description: 服务器类型
 * @author: l't
 * @create: 2019-07-24 15:41
 **/
public enum ServerType {
    ELASTICSEARCH(1,"elasticsearch"),MYSQL(2,"mysql"),MONGODB(3,"mongodb"),REDIS(4,"redis");
    private int type;
    private String name;

    ServerType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }
}
