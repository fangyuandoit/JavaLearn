package 枚举;

/**
 * @program: springboot_v2
 * @description: 数据库的处理状态
 * @author: l't
 * @create: 2019-07-19 14:02
 * 处理状态(0:未处理;1:无法连接;2:预览中;3:预览完成;4:下载中,5:下载完成,6：没有数据)
 **/
public enum DealStatus {
    NODEAL(0),NOTCONNECT(1),PREVIEWING(2),PREVIEWED(3),DOWNING(4),DOWNED(5),NODATA(6);

    DealStatus(int status) {
        this.status = status;
    }

    private int status;

    public int getStatus() {
        return status;
    }
}
