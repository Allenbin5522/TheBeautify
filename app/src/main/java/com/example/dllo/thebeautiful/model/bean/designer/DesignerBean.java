package com.example.dllo.thebeautiful.model.bean.designer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by dllo on 16/8/17.
 */
public class DesignerBean implements Parcelable {

    /**
     * has_next : 1
     * designers : [{"city":"伦敦","concept":"当你的品牌能够被他人预测的时候，你就遇上大麻烦了","name":"Jonathan Anderson","label":"J.W.Anderson 创始人，Loewe 创意总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/12/1c550e7b-56cf-44a2-af40-7bfe07f0827b.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/12/89aec0a9-48a7-4858-95d4-dac3b752b94d_1000x625.jpeg"],"id":82},{"city":"旧金山","concept":"没有必要在道义和美感之间妥协","name":"Rachel Gant & Andrew Deming","label":"Yield 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/16/cc971222-1f6e-4610-a141-36aeedcf1667.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/16/cffcc0a5-f548-4868-9460-3261b390e458_1000x625.jpeg"],"id":79},{"city":"纽约","concept":"唯有打开眼界和内心，灵感才会涌来","name":"Virginie Millefiori","label":"Virginie Millefiori 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/16/740ef4d2-bb4d-4b19-b7ce-576d57d896ff.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/16/fc9a35f9-9c77-4f0e-b759-3ebebbfbca02_1000x625.jpeg"],"id":78},{"city":"纽约","concept":"绝不忍受无趣和停滞不前","name":"Phoebe Sung & Peter Buer","label":"Cold Picnic 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/16/74dce2f6-ebaa-4ee2-9837-8dc9737ce302.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/16/3462de67-609a-4804-8389-8051a867a4a6_1000x625.jpeg"],"id":76},{"city":"纽约","concept":"最让我激动的是时刻就是想法变成了触手可及的实体","name":"Jessica Kertis Ulrich ","label":"Kertis 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/16/9a33d81b-2391-4225-bee3-0a0f42b68f78.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/16/23064269-7c02-4833-b01a-fb190d447eb7_1000x625.jpeg"],"id":74},{"city":"伦敦","concept":"Charlotte Olympia的品牌灵魂来源于我对40年代好莱坞魅力的怀念","name":"Charlotte Dellal","label":"Charlotte Olympia 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/12/130137b2-cd64-4384-8b13-c4ce16ce4147.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/12/5f936c34-1019-4a28-96f4-d0b11eed49ca_1000x625.jpeg"],"id":73},{"city":"温哥华","concept":"为无畏的灵魂而设计","name":"Sandra Silveyra","label":"Olivia The Wolf 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/5/fc1f27ba-ed73-478e-97bb-aaf1d6b31f6c.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/5/43d656f7-7c48-4f54-ac02-72d088c53095_1000x625.jpeg"],"id":68},{"city":"波特兰","concept":"追求坦诚和直接而明确的设计观念","name":"Sam Huff","label":"Tanner Goods 创始人，创意总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/8/827e1723-5aab-4864-b87b-69be0e353714.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/8/1f10de4e-a7d0-4ba0-a32e-4e8877b0152e_1000x625.jpeg"],"id":67},{"city":"伦敦","concept":"我的每件作品之间都是相互传承的","name":"Mei-Li Rose ","label":"Mei-Li Rose 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/5/f71befee-eab8-4e18-b582-7e9b62fd112b.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/5/2aa248ed-8460-434a-b6c6-131296fef008_1000x625.jpeg"],"id":66},{"city":"纽约","concept":"灵感无处不在，只要拿起画笔，它们都能转化成艺术","name":"Anthony Lent","label":"Anthony Lent 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/6/f97805c6-9047-450b-866d-b5e00b493594.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/6/cc6cdd07-6974-4f83-b67f-5a23cdb3d75a_1000x625.jpeg"],"id":65},{"city":"纽约","concept":"我的作品宣扬个性，好奇心和现代","name":"Sarah Law","label":"Kara 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/24/26061db9-6afa-4b3a-8e2a-844df61544e9.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/5/6969b1bc-429b-4ed4-8c80-1aa26eb08495_1000x625.jpeg"],"id":64},{"city":"西雅图","concept":"任何东西都是有灵魂的","name":"David Shabtai","label":"Smoke x Mirrors 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/24/a57f37f0-57d1-4da4-a296-c761146f2d32.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/15/8ff54270-0d28-4a0e-b75c-d26ec6181f0d_1000x625.jpeg"],"id":63},{"city":"西雅图","concept":"有趣的方式才会产生有趣的想法","name":"Seth Grizzle & Jonathan Junker","label":"Graypants 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/24/dcf81920-69d9-4dff-931a-5ca649f50ebf.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/11/4ebb75fe-d41f-4d79-b070-4681e91a3b12_1000x625.jpeg"],"id":62},{"city":"西雅图","concept":"追求少而美的质感生活","name":"Darin Montgomery","label":"urbancase 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/22/2e15a6d6-e0a5-4436-a98a-ea45546b9d62.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/7/23/0f901e8c-486f-4b9b-b2df-9c27fd2ae99d_1000x625.jpeg"],"id":61},{"city":"波特兰","concept":"现代的设计和良心的制造是我工作的核心","name":"Monika Reed","label":"Favor 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/22/8a5dc597-1ab8-4326-8a05-479a1a294b52.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/7/23/7e529341-117e-40ee-bf6d-712485502019_1000x625.jpeg"],"id":60},{"city":"纽约","concept":"旅行是灵感的来源和一次发现有趣材料的机会","name":"Renee Kopec","label":"Renee Frances 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/16/85e19ba0-07b8-4dda-89a2-97db6af095dd.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/16/565441dd-4dc4-44c3-a7c6-672f87bc7f25_1000x625.jpeg"],"id":59},{"city":"纽约","concept":"我只想设计出有趣好玩的墨镜","name":"Carla Robertson Higgins","label":"Carla Colour 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/22/5b190635-7da6-42c7-ab47-bb42542300da.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/7/22/466bf886-8aa4-41cc-a2cd-c1931534fade_1000x625.jpeg"],"id":58},{"city":"","concept":"","name":"Kika Vliegenthart","label":"kikany 联合创始人 ","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/16/7175717d-8374-46bc-ad7a-1bdb42284d57.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/16/98a3088a-5642-4db2-bcb6-56d1c42f2906_1000x625.jpeg"],"id":57},{"city":"","concept":"香气的融合如人与人间的关系一样复杂。","name":"Tamara Mayne","label":"Brooklyn Candle Studio 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/21/35bfb326-703e-4d0c-860b-f05d39cec349.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/7/21/23471bf4-86c8-47a9-ab1d-98216a65164e_1000x625.jpeg"],"id":56},{"city":"纽约","concept":"透明化是关键","name":"Blair Lauren Brown","label":"Blair Lauren Brown 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/21/f33c7fc2-f46e-43e8-b3a0-fd967e2949e1.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/7/23/5e88804b-2fe3-47ec-978d-e888ce59cfa1_1000x625.jpeg"],"id":55},{"city":"伦敦","concept":"对女性教育的投资回报远远要高于预期","name":"Mille Yu","label":"Daame 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/2/298a008b-f766-428d-9528-113593630b72.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/2/24ad467c-a033-4615-b981-5279fc334ae9_1000x625.jpeg"],"id":54},{"city":"布里斯班","concept":"每一件皮制品都是独一无二的并且随着岁月的流逝会越发美丽","name":"Reza Ekarantio","label":"Ped's & Ro 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/1/0d20462d-5a54-4a4d-b74d-5104b3ea95f1.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/1/03f6dd98-947b-4e58-bfe0-25d3c82fe123_1000x625.jpeg"],"id":53},{"city":"旧金山","concept":"希望我的艺术天赋能像音乐一样流动","name":"Jessica Kramer","label":"Hawkhouse 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/1/3f3f673b-8dfe-4e73-b2ae-993f6034d861.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/1/89a565be-8319-48b9-9906-3b4e8e3df64d_1000x625.jpeg"],"id":50},{"city":"纽约","concept":"设计是一本神秘而独特的文学书","name":"Janet Cadsawan ","label":"Cadsawan 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/1/9c115779-931e-4858-b64b-27baa9569e6b.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/1/a0c192ce-134b-4adc-89a6-d78e83a51fc6_1000x625.jpeg"],"id":49},{"city":"新加坡","concept":"40岁时我才明白我的归属和热情所在是设计","name":"Carolyn Kan","label":"Carrie K. Jewellery 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/20/be6b2e74-2200-47c5-884a-7847e9f3c6d5.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/5/36d5720c-cf14-4005-bddb-c53d7963d9c8_1000x625.jpeg"],"id":46},{"city":"纽约","concept":"我的作品是我个人生活的演变和进化","name":"Chris Habana","label":"Chrishabana 创始人 ","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/2/3b70f136-3ae3-4c9d-b644-2978cbb8ede6.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/4/da3931cb-d2ac-4835-9437-4945961a3b11_1000x625.jpeg"],"id":45},{"city":"波特兰","concept":"纤维也能创造故事和传奇","name":"Dawn Yanagihara","label":"Kiriko 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/3/2420d4cf-9cf1-483c-b81e-af0056dec46c.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/4/fe1d3aca-f1ce-4cd1-9755-73e020c91c60_1000x625.jpeg"],"id":44},{"city":"洛杉矶","concept":"我是艺术家，而不是设计师","name":"Jessica Taft Langdon","label":"The Palatines 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/6/e6abb9f9-4ad3-4aa7-82c9-c453ffdafb5e.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/6/eb4223c6-e127-4025-b280-ea192e79f4ce_1000x625.jpeg"],"id":43},{"city":"","concept":"为有个性的人而设计","name":"Karen Walker","label":"Karen Walker 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/1/32071d69-bd7e-4c40-a02f-76fa6ea92a4c.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/1/5ca179f9-4dda-4df4-89c1-164f8e4efb98_1000x625.jpeg"],"id":42},{"city":"纽约","concept":"我喜欢小规模的细节和过程以及组合东西的感觉","name":"Katrina LaPenne","label":"Katrina LaPenne 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/20/e804e13c-4c00-46ce-98bd-e5fba5eba0bf.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/7/20/943ce001-25ed-4491-b2e7-acf08590486c_1000x625.jpeg"],"id":41}]
     */

    private DataBean data;
    /**
     * data : {"has_next":1,"designers":[{"city":"伦敦","concept":"当你的品牌能够被他人预测的时候，你就遇上大麻烦了","name":"Jonathan Anderson","label":"J.W.Anderson 创始人，Loewe 创意总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/12/1c550e7b-56cf-44a2-af40-7bfe07f0827b.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/12/89aec0a9-48a7-4858-95d4-dac3b752b94d_1000x625.jpeg"],"id":82},{"city":"旧金山","concept":"没有必要在道义和美感之间妥协","name":"Rachel Gant & Andrew Deming","label":"Yield 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/16/cc971222-1f6e-4610-a141-36aeedcf1667.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/16/cffcc0a5-f548-4868-9460-3261b390e458_1000x625.jpeg"],"id":79},{"city":"纽约","concept":"唯有打开眼界和内心，灵感才会涌来","name":"Virginie Millefiori","label":"Virginie Millefiori 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/16/740ef4d2-bb4d-4b19-b7ce-576d57d896ff.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/16/fc9a35f9-9c77-4f0e-b759-3ebebbfbca02_1000x625.jpeg"],"id":78},{"city":"纽约","concept":"绝不忍受无趣和停滞不前","name":"Phoebe Sung & Peter Buer","label":"Cold Picnic 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/16/74dce2f6-ebaa-4ee2-9837-8dc9737ce302.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/16/3462de67-609a-4804-8389-8051a867a4a6_1000x625.jpeg"],"id":76},{"city":"纽约","concept":"最让我激动的是时刻就是想法变成了触手可及的实体","name":"Jessica Kertis Ulrich ","label":"Kertis 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/16/9a33d81b-2391-4225-bee3-0a0f42b68f78.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/16/23064269-7c02-4833-b01a-fb190d447eb7_1000x625.jpeg"],"id":74},{"city":"伦敦","concept":"Charlotte Olympia的品牌灵魂来源于我对40年代好莱坞魅力的怀念","name":"Charlotte Dellal","label":"Charlotte Olympia 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/12/130137b2-cd64-4384-8b13-c4ce16ce4147.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/12/5f936c34-1019-4a28-96f4-d0b11eed49ca_1000x625.jpeg"],"id":73},{"city":"温哥华","concept":"为无畏的灵魂而设计","name":"Sandra Silveyra","label":"Olivia The Wolf 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/5/fc1f27ba-ed73-478e-97bb-aaf1d6b31f6c.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/5/43d656f7-7c48-4f54-ac02-72d088c53095_1000x625.jpeg"],"id":68},{"city":"波特兰","concept":"追求坦诚和直接而明确的设计观念","name":"Sam Huff","label":"Tanner Goods 创始人，创意总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/8/827e1723-5aab-4864-b87b-69be0e353714.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/8/1f10de4e-a7d0-4ba0-a32e-4e8877b0152e_1000x625.jpeg"],"id":67},{"city":"伦敦","concept":"我的每件作品之间都是相互传承的","name":"Mei-Li Rose ","label":"Mei-Li Rose 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/5/f71befee-eab8-4e18-b582-7e9b62fd112b.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/5/2aa248ed-8460-434a-b6c6-131296fef008_1000x625.jpeg"],"id":66},{"city":"纽约","concept":"灵感无处不在，只要拿起画笔，它们都能转化成艺术","name":"Anthony Lent","label":"Anthony Lent 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/6/f97805c6-9047-450b-866d-b5e00b493594.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/6/cc6cdd07-6974-4f83-b67f-5a23cdb3d75a_1000x625.jpeg"],"id":65},{"city":"纽约","concept":"我的作品宣扬个性，好奇心和现代","name":"Sarah Law","label":"Kara 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/24/26061db9-6afa-4b3a-8e2a-844df61544e9.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/5/6969b1bc-429b-4ed4-8c80-1aa26eb08495_1000x625.jpeg"],"id":64},{"city":"西雅图","concept":"任何东西都是有灵魂的","name":"David Shabtai","label":"Smoke x Mirrors 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/24/a57f37f0-57d1-4da4-a296-c761146f2d32.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/15/8ff54270-0d28-4a0e-b75c-d26ec6181f0d_1000x625.jpeg"],"id":63},{"city":"西雅图","concept":"有趣的方式才会产生有趣的想法","name":"Seth Grizzle & Jonathan Junker","label":"Graypants 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/24/dcf81920-69d9-4dff-931a-5ca649f50ebf.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/11/4ebb75fe-d41f-4d79-b070-4681e91a3b12_1000x625.jpeg"],"id":62},{"city":"西雅图","concept":"追求少而美的质感生活","name":"Darin Montgomery","label":"urbancase 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/22/2e15a6d6-e0a5-4436-a98a-ea45546b9d62.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/7/23/0f901e8c-486f-4b9b-b2df-9c27fd2ae99d_1000x625.jpeg"],"id":61},{"city":"波特兰","concept":"现代的设计和良心的制造是我工作的核心","name":"Monika Reed","label":"Favor 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/22/8a5dc597-1ab8-4326-8a05-479a1a294b52.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/7/23/7e529341-117e-40ee-bf6d-712485502019_1000x625.jpeg"],"id":60},{"city":"纽约","concept":"旅行是灵感的来源和一次发现有趣材料的机会","name":"Renee Kopec","label":"Renee Frances 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/16/85e19ba0-07b8-4dda-89a2-97db6af095dd.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/16/565441dd-4dc4-44c3-a7c6-672f87bc7f25_1000x625.jpeg"],"id":59},{"city":"纽约","concept":"我只想设计出有趣好玩的墨镜","name":"Carla Robertson Higgins","label":"Carla Colour 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/22/5b190635-7da6-42c7-ab47-bb42542300da.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/7/22/466bf886-8aa4-41cc-a2cd-c1931534fade_1000x625.jpeg"],"id":58},{"city":"","concept":"","name":"Kika Vliegenthart","label":"kikany 联合创始人 ","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/16/7175717d-8374-46bc-ad7a-1bdb42284d57.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/16/98a3088a-5642-4db2-bcb6-56d1c42f2906_1000x625.jpeg"],"id":57},{"city":"","concept":"香气的融合如人与人间的关系一样复杂。","name":"Tamara Mayne","label":"Brooklyn Candle Studio 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/21/35bfb326-703e-4d0c-860b-f05d39cec349.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/7/21/23471bf4-86c8-47a9-ab1d-98216a65164e_1000x625.jpeg"],"id":56},{"city":"纽约","concept":"透明化是关键","name":"Blair Lauren Brown","label":"Blair Lauren Brown 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/21/f33c7fc2-f46e-43e8-b3a0-fd967e2949e1.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/7/23/5e88804b-2fe3-47ec-978d-e888ce59cfa1_1000x625.jpeg"],"id":55},{"city":"伦敦","concept":"对女性教育的投资回报远远要高于预期","name":"Mille Yu","label":"Daame 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/2/298a008b-f766-428d-9528-113593630b72.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/2/24ad467c-a033-4615-b981-5279fc334ae9_1000x625.jpeg"],"id":54},{"city":"布里斯班","concept":"每一件皮制品都是独一无二的并且随着岁月的流逝会越发美丽","name":"Reza Ekarantio","label":"Ped's & Ro 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/1/0d20462d-5a54-4a4d-b74d-5104b3ea95f1.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/1/03f6dd98-947b-4e58-bfe0-25d3c82fe123_1000x625.jpeg"],"id":53},{"city":"旧金山","concept":"希望我的艺术天赋能像音乐一样流动","name":"Jessica Kramer","label":"Hawkhouse 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/1/3f3f673b-8dfe-4e73-b2ae-993f6034d861.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/1/89a565be-8319-48b9-9906-3b4e8e3df64d_1000x625.jpeg"],"id":50},{"city":"纽约","concept":"设计是一本神秘而独特的文学书","name":"Janet Cadsawan ","label":"Cadsawan 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/1/9c115779-931e-4858-b64b-27baa9569e6b.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/1/a0c192ce-134b-4adc-89a6-d78e83a51fc6_1000x625.jpeg"],"id":49},{"city":"新加坡","concept":"40岁时我才明白我的归属和热情所在是设计","name":"Carolyn Kan","label":"Carrie K. Jewellery 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/20/be6b2e74-2200-47c5-884a-7847e9f3c6d5.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/5/36d5720c-cf14-4005-bddb-c53d7963d9c8_1000x625.jpeg"],"id":46},{"city":"纽约","concept":"我的作品是我个人生活的演变和进化","name":"Chris Habana","label":"Chrishabana 创始人 ","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/2/3b70f136-3ae3-4c9d-b644-2978cbb8ede6.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/4/da3931cb-d2ac-4835-9437-4945961a3b11_1000x625.jpeg"],"id":45},{"city":"波特兰","concept":"纤维也能创造故事和传奇","name":"Dawn Yanagihara","label":"Kiriko 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/3/2420d4cf-9cf1-483c-b81e-af0056dec46c.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/4/fe1d3aca-f1ce-4cd1-9755-73e020c91c60_1000x625.jpeg"],"id":44},{"city":"洛杉矶","concept":"我是艺术家，而不是设计师","name":"Jessica Taft Langdon","label":"The Palatines 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/6/e6abb9f9-4ad3-4aa7-82c9-c453ffdafb5e.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/6/eb4223c6-e127-4025-b280-ea192e79f4ce_1000x625.jpeg"],"id":43},{"city":"","concept":"为有个性的人而设计","name":"Karen Walker","label":"Karen Walker 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/1/32071d69-bd7e-4c40-a02f-76fa6ea92a4c.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/8/1/5ca179f9-4dda-4df4-89c1-164f8e4efb98_1000x625.jpeg"],"id":42},{"city":"纽约","concept":"我喜欢小规模的细节和过程以及组合东西的感觉","name":"Katrina LaPenne","label":"Katrina LaPenne 创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/7/20/e804e13c-4c00-46ce-98bd-e5fba5eba0bf.jpg","recommend_images":["http://dstatic.zuimeia.com/common/image/2016/7/20/943ce001-25ed-4491-b2e7-acf08590486c_1000x625.jpeg"],"id":41}]}
     * result : 1
     */

    private int result;

    protected DesignerBean(Parcel in) {
        result = in.readInt();
    }

    public static final Creator<DesignerBean> CREATOR = new Creator<DesignerBean>() {
        @Override
        public DesignerBean createFromParcel(Parcel in) {
            return new DesignerBean(in);
        }

        @Override
        public DesignerBean[] newArray(int size) {
            return new DesignerBean[size];
        }
    };

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(result);
    }

    public static class DataBean {
        private int has_next;
        /**
         * city : 伦敦
         * concept : 当你的品牌能够被他人预测的时候，你就遇上大麻烦了
         * name : Jonathan Anderson
         * label : J.W.Anderson 创始人，Loewe 创意总监
         * avatar_url : http://dstatic.zuimeia.com/designer/avatar/2016/8/12/1c550e7b-56cf-44a2-af40-7bfe07f0827b.jpg
         * recommend_images : ["http://dstatic.zuimeia.com/common/image/2016/8/12/89aec0a9-48a7-4858-95d4-dac3b752b94d_1000x625.jpeg"]
         * id : 82
         */

        private List<DesignersBean> designers;

        public int getHas_next() {
            return has_next;
        }

        public void setHas_next(int has_next) {
            this.has_next = has_next;
        }

        public List<DesignersBean> getDesigners() {
            return designers;
        }

        public void setDesigners(List<DesignersBean> designers) {
            this.designers = designers;
        }

        public static class DesignersBean {
            private String city;
            private String concept;
            private String name;
            private String label;
            private String avatar_url;
            private int id;
            private List<String> recommend_images;

            @Override
            public String toString() {
                return "DesignersBean{" +
                        "city='" + city + '\'' +
                        ", concept='" + concept + '\'' +
                        ", name='" + name + '\'' +
                        ", label='" + label + '\'' +
                        ", avatar_url='" + avatar_url + '\'' +
                        ", id=" + id +
                        ", recommend_images=" + recommend_images +
                        '}';
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getConcept() {
                return concept;
            }

            public void setConcept(String concept) {
                this.concept = concept;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public List<String> getRecommend_images() {
                return recommend_images;
            }

            public void setRecommend_images(List<String> recommend_images) {
                this.recommend_images = recommend_images;
            }
        }
    }
}
