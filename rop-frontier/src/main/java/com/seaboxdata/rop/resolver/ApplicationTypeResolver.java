package com.seaboxdata.rop.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.api.vo.ApplicationTypeVo;
import com.seaboxdata.rop.api.input.ApplicationTypeInput;
import com.seaboxdata.rop.api.input.ApplicationTypePageInput;
import com.seaboxdata.rop.service.NrdApplicationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 应用分类 -- resolver
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-24 14:51:29
 */
@Service
public class ApplicationTypeResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private NrdApplicationTypeService nrdApplicationTypeService;

    /**
     * 分页
     */
    public PaginationResult<ApplicationTypeVo> applicationTypeList(ApplicationTypePageInput applicationTypePageInput){
        return nrdApplicationTypeService.applicationTypeList(applicationTypePageInput);
    }

    /**
     * 全部
     */
    public List<ApplicationTypeVo> applicationTypeAll(ApplicationTypeInput applicationTypeInput){
        return nrdApplicationTypeService.applicationTypeAll(applicationTypeInput);
    }

    /**
     * 信息
     */
    public ApplicationTypeVo applicationTypeDetail(Integer appTypeId){
        return nrdApplicationTypeService.applicationTypeDetail(appTypeId);

    }

    /**
     * 保存
     */
    public Boolean applicationTypeSave(ApplicationTypeInput applicationTypeInput){
        return nrdApplicationTypeService.applicationTypeSave(applicationTypeInput);
    }

    /**
     * 修改
     */
    public Boolean applicationTypeUpdate(ApplicationTypeInput applicationTypeInput){
        return nrdApplicationTypeService.applicationTypeUpdate(applicationTypeInput);
    }

    /**
     * 删除
     */
    public Boolean applicationTypeDelete(Integer[] appTypeIds){
        return nrdApplicationTypeService.applicationTypeDelete(appTypeIds);
    }

}
