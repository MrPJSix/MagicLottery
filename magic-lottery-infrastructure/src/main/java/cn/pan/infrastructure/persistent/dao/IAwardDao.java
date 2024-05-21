package cn.pan.infrastructure.persistent.dao;

import cn.pan.infrastructure.persistent.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author MrPJSix
 * @description 奖品表Dao
 * @date 2024/5/21 19:25
 */
@Mapper
public interface IAwardDao {
    List<Award> queryAwardList();
}
