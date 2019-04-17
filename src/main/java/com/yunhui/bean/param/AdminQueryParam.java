package com.yunhui.bean.param;
import com.yunhui.common.page.PageOption;
import lombok.Data;

@Data
public class AdminQueryParam extends PageOption {

    private Long roleId;

    private String adminNick;
}
