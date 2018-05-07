import com.sinet.main.Cosine;
import com.sinet.main.CosineUtil;

import java.util.Map;

public class Test {

    public static void main(String[] args) throws Exception {
        String s1 = "本专题将研究开发低重稀土Nd-Fe-B烧结永磁材料的制备技术，并建成一条年产3000吨高性能钕铁硼永磁材料生产线。主要研发内容包括：1)制备永磁材料母合金的研究；2)制粉工艺的研究；3)成型技术及烧结工艺的研究；4)Magrise技术及研究表面处理技术的研究等。";
        String s2 = "项目是依据多项专利进行设备、染料、印花纸和工艺研发的。其技术是将水溶活性环保染料印刷成印花纸；再将印花纸图案转移到织物上，经固色水洗后形成成品。该技术克服了传统印花技术的高能耗、高污染、低效率的缺点；印花产品达到数码照相级水平，市场巨大。";

        Map<String, Integer> map1 = CosineUtil.participle(s1);
        Map<String, Integer> map2 = CosineUtil.participle(s2);

        System.out.println(CosineUtil.similarity(map1,map2));

    }
}
