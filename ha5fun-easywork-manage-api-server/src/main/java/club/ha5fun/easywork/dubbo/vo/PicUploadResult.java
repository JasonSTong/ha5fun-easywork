package club.ha5fun.easywork.dubbo.vo;

import lombok.Data;

/**
 * @author chen
 * @Company ha5fun.club
 */
@Data
public class PicUploadResult {
    /**
     * 文件唯一标识
     */
    private String uid;
    /**
     * 文件名
     */
    private String name;
    /**
     * 状态：（uploading ,done ,error ,remove)
     */
    private String status;
    /**
     * 服务端响应内容
     */
    private String response;
}
