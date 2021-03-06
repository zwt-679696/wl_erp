package com.weiling.wl_erp.service;

import com.weiling.wl_erp.bean.Sell;
import com.weiling.wl_erp.mapper.SellMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/13
 * 销售信息
 */
@Service
public class SellService {
    @Autowired
    private SellMapper sellMapper;

    public int insertSell(Sell sell){
        return sellMapper.insertSell(sell);
    }
    public  List<Sell> findAllSell(String pname,String cname,Date starttime,Date overtime){

        return sellMapper.findAllSell(pname,cname,starttime,overtime);
    }
    public Sell findSellById(Integer id){
        return sellMapper.findSellById(id);
    }
    public List<Sell> findByNameAndTime(String pname,String cname,String guige){
        return sellMapper.findSellByName(pname,cname,guige);
    }
    public int updateZhuangTai(Integer id,Integer zhuangtai){
        return sellMapper.updateZhuangTai(id,zhuangtai);
    }
    public int updateSellById(Sell sell){
        return sellMapper.updateSellById(sell);
    }
    public int findSellByZhuangtai(String pname,String cname,String guige){
        return sellMapper.findSellByZhuangtai(pname,cname,guige)==null?0:sellMapper.findSellByZhuangtai(pname,cname,guige);
    }
    public int updateSellName(String pname,String cname,String odpname,String odcname){
        return sellMapper.updateSellName(pname,cname,odpname,odcname);
    }
    public Sell findSellByOrder(String ordercode){
        return sellMapper.findSellByOrder(ordercode);
    }
}
