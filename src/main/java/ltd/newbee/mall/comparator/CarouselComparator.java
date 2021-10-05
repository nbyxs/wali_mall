package ltd.newbee.mall.comparator;

import ltd.newbee.mall.entity.Carousel;

import java.util.Comparator;
//轮播图根据排序值排序
public class CarouselComparator implements Comparator<Carousel> {


    @Override
    public int compare(Carousel o1, Carousel o2) {
        return o1.getCarouselRank()-o2.getCarouselRank();
    }
}
