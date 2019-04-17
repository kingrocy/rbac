package com.yunhui.bean.param;
import com.yunhui.common.page.PageOption;
import lombok.Data;

@Data
public class RoleQueryParam extends PageOption {

    private String roleName;
}
