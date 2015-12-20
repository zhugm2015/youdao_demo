package ioc.c;

/**
 * Created by Administrator on 2015/12/19.
 */
public class Business {
    private DeviceWriter deviceWriter;

    /*//方式一:构造器
    public Business(DeviceWriter deviceWriter) {
        this.deviceWriter = deviceWriter;
    }*/

    //方式二:getter方法
    public void setDeviceWriter(DeviceWriter deviceWriter) {
        this.deviceWriter = deviceWriter;
    }

    public void write(){
        deviceWriter.writeToDevice();
    }
}
