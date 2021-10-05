package ltd.newbee.mall.service.impl;

import ltd.newbee.mall.dao.AdminUserMapper;
import ltd.newbee.mall.dao.ReviewMapper;
import ltd.newbee.mall.entity.AdminUser;
import ltd.newbee.mall.entity.Review;
import ltd.newbee.mall.entity.ReviewExample;
import ltd.newbee.mall.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ReviewImpl implements ReviewService {
    @Autowired
    ReviewMapper reviewMapper;
    @Autowired
    AdminUserMapper adminUserMapper;
    @Override
    public void insert(Review review) {

        reviewMapper.insert(review);
    }


    @Override
    public Map<String, String> getReview(Long goodsId) {
        ReviewExample example=new ReviewExample();
        ReviewExample.Criteria criteria=example.createCriteria();
        criteria.andGoodsIdEqualTo(goodsId);
        List<Review> reviewList=reviewMapper.selectByExample(example);
        Map<String,String> map=new HashMap<>();
        for(Review review:reviewList){
           AdminUser adminUser= adminUserMapper.selectByPrimaryKey( review.getUserId());
           map.put(adminUser.getNickName(),review.getContent());
        }
        return map;
    }
}
