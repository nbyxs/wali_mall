package ltd.newbee.mall.service;

import ltd.newbee.mall.entity.Review;

import java.util.Map;

public interface ReviewService {
    public void insert(Review review);
    public Map<String ,String> getReview(Long goodsId);
}
