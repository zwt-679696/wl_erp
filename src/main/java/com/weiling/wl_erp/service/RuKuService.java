package com.weiling.wl_erp.service;

import com.weiling.wl_erp.bean.KuCun;
import com.weiling.wl_erp.bean.RuKu;
import com.weiling.wl_erp.mapper.KuCunMapper;
import com.weiling.wl_erp.mapper.RuKuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/12
 * 入库相关信息
 */
@Service
public class RuKuService {
    @Autowired
    private RuKuMapper ruKuMapper;

    public int insertRuKu(RuKu ruKu){
        return ruKuMapper.insertRuKu(ruKu);
    }

    public List<RuKu> findAllRuKu(String pname,String cname,Date starttime,Date overtime){
        return ruKuMapper.findAllRuKu(pname,cname,starttime,overtime);
    }

    public RuKu findRuKuById(Integer id){
        return ruKuMapper.findRuKuById(id);
    }

    public int updateRuKuById(RuKu ruKu){
        return ruKuMapper.updateRuKuById(ruKu);
    }

    public List<RuKu> findRuKuByName(String pname,String cname,String guige){
        return ruKuMapper.findRuKuByName(pname,cname,guige);
    }

    public int deleteRuKuById(Integer id){
        return ruKuMapper.deleteRuKuById(id);
    }
    public int updateRuKuName(String pname,String cname,String odpname,String odcname){
        return ruKuMapper.updateRuKuName(pname,cname,odpname,odcname);
    }




























}
