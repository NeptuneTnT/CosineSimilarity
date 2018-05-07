# CosineSimilarity
计算文本相似度工具类

> test
```
String s1 = "本项目研究的目的在于，解决我国目前从模拟对讲机向数字对讲机产业转移的难题，研究设计可实现产业化的高性能数字对讲机设备。";
String s2 = "本项目研究的目的在于：解决我国模拟对讲机产业向数字对讲机产业转移的重大技术难题，研究设计开发出高性能数字对讲机设备，推动实现其产业化目标。";
String s3 = "本项目研究的目的在于，解决我国目前从模拟对讲机向数字对讲机产业转移的难题，研究设计可实现产业化的高性能数字对讲机设备。";
String s4 = "项目是依据多项专利进行设备、染料、印花纸和工艺研发的。其技术是将水溶活性环保染料印刷成印花纸；再将印花纸图案转移到织物上，经固色水洗后形成成品。该技术克服了传统印花技术的高能耗、高污染、低效率的缺点；印花产品达到数码照相级水平，市场巨大。";

Map<String, Integer> map1 = CosineUtil.participle(s1);
Map<String, Integer> map2 = CosineUtil.participle(s2);
Map<String, Integer> map4 = CosineUtil.participle(s4);

System.out.println("相似度：" + CosineUtil.similarity(map1,map2));
System.out.println("相似度：" + CosineUtil.similarity(map1,map3));
System.out.println("相似度：" + CosineUtil.similarity(map1,map4));
```

> console
```
相似度：0.6515703699002945
相似度：1.0
相似度：0.0

```
