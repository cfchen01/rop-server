package com.seaboxdata.rop.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.api.vo.InfoResApplicationVo;
import com.seaboxdata.rop.api.input.InfoResApplicationInput;
import com.seaboxdata.rop.api.input.InfoResApplicationPageInput;
import com.seaboxdata.rop.service.NrdInfoResApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据应用 -- resolver
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-27 15:12:12
 */
@Service
public class InfoResApplicationResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private NrdInfoResApplicationService nrdInfoResApplicationService;

    /**
     * 分页
     */
    public PaginationResult<InfoResApplicationVo> infoResApplicationList(InfoResApplicationPageInput infoResApplicationPageInput){
        return nrdInfoResApplicationService.infoResApplicationList(infoResApplicationPageInput);
    }

    /**
     * 全部
     */
    public List<InfoResApplicationVo> infoResApplicationAll(InfoResApplicationInput infoResApplicationInput){
        return nrdInfoResApplicationService.infoResApplicationAll(infoResApplicationInput);
    }

    /**
     * 信息
     */
    public InfoResApplicationVo infoResApplicationDetail(Integer appId){
        return nrdInfoResApplicationService.infoResApplicationDetail(appId);

    }

    /**
     * 保存
     */
    public Boolean infoResApplicationSave(InfoResApplicationInput infoResApplicationInput){
        return nrdInfoResApplicationService.infoResApplicationSave(infoResApplicationInput);
    }

    /**
     * 修改
     */
    public Boolean infoResApplicationUpdate(InfoResApplicationInput infoResApplicationInput){
        return nrdInfoResApplicationService.infoResApplicationUpdate(infoResApplicationInput);
    }

    /**
     * 删除
     */
    public Boolean infoResApplicationDelete(Integer[] appIds){
        return nrdInfoResApplicationService.infoResApplicationDelete(appIds);
    }

}
