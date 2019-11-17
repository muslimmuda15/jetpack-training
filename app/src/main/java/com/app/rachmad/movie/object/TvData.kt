package com.app.rachmad.movie.`object`

import java.io.Serializable

data class TvData(
        val id: Int,
        val vote_count: Int,
        val video: Boolean,
        val vote_average: Float,
        val name: List<String>,
        val popularity: Float,
        val poster_path: String,
        val original_language: String,
        val original_name: String?,
        val genre_ids: List<String>,
        val overview: List<String>,
        val release_date: String,
        val adult: Boolean,
        val backdrop_path: String
): Serializable

data class TvBaseData(
        val results: List<TvData>,
        val page: Int,
        val total_results: Int,
        val total_pages: Int
): Serializable {
    companion object {
        val TV = "{\n" +
                "  \"page\": 1,\n" +
                "  \"total_results\": 10000,\n" +
                "  \"total_pages\": 500,\n" +
                "  \"results\": [\n" +
                "      {\n" +
                "          \"original_name\": \"The Flash\",\n" +
                "          \"genre_ids\": [\n" +
                "              18,\n" +
                "              10765\n" +
                "          ],\n" +
                "          \"name\": [\"The Flash\", \"Kilat\"],\n" +
                "          \"popularity\": 265.75,\n" +
                "          \"origin_country\": [\n" +
                "              \"US\"\n" +
                "          ],\n" +
                "          \"vote_count\": 2809,\n" +
                "          \"release_date\": \"2014-10-07\",\n" +
                "          \"backdrop_path\": \"/jC1KqsFx8ZyqJyQa2Ohi7xgL7XC.jpg\",\n" +
                "          \"original_language\": \"en\",\n" +
                "          \"id\": 60735,\n" +
                "          \"vote_average\": 6.6,\n" +
                "          \"overview\": [\"After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.\", \"Setelah akselerator partikel menyebabkan badai aneh, Penyelidik CSI Barry Allen disambar petir dan jatuh koma. Beberapa bulan kemudian dia terbangun dengan kekuatan kecepatan super, memberinya kemampuan untuk bergerak melalui Central City seperti malaikat penjaga yang tak terlihat. Meskipun awalnya senang dengan kekuatan barunya, Barry terkejut menemukan bahwa dia bukan satu-satunya \\\"manusia meta\\\" yang diciptakan setelah ledakan akselerator - dan tidak semua orang menggunakan kekuatan baru mereka untuk kebaikan. Barry bermitra dengan S.T.A.R. Lab dan mendedikasikan hidupnya untuk melindungi yang tidak bersalah. Untuk saat ini, hanya beberapa teman dekat dan rekan yang tahu bahwa Barry secara harfiah adalah manusia tercepat, tetapi tidak lama sebelum dunia mengetahui apa yang menjadi Barry Allen ... The Flash.\"],\n" +
                "          \"poster_path\": \"/fki3kBlwJzFp8QohL43g9ReV455.jpg\"\n" +
                "      },\n" +
                "      {\n" +
                "            \"original_name\": \"Family Guy\",\n" +
                "            \"genre_ids\": [\n" +
                "                16,\n" +
                "                35\n" +
                "            ],\n" +
                "            \"name\": [\"Family Guy\", \"Keluarga Laki-laki\"],\n" +
                "            \"popularity\": 217.192,\n" +
                "            \"origin_country\": [\n" +
                "                \"US\"\n" +
                "            ],\n" +
                "            \"vote_count\": 1610,\n" +
                "            \"release_date\": \"1999-01-31\",\n" +
                "            \"backdrop_path\": \"/3OFrs1ets87VmRvG78Zg5eJTZeq.jpg\",\n" +
                "            \"original_language\": \"en\",\n" +
                "            \"id\": 1434,\n" +
                "            \"vote_average\": 6.5,\n" +
                "            \"overview\": [\"Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.\", \"Seri animasi animasi Freakin 'Sweet yang sakit, terpelintir, dan salah, menampilkan petualangan keluarga Griffin yang disfungsional. Peter yang kikuk dan Lois yang sudah lama menderita memiliki tiga anak. Stewie (bayi yang brilian tetapi sadis yang bertekad membunuh ibunya dan mengambil alih dunia), Meg (yang tertua, dan merupakan gadis yang paling tidak populer di kota) dan Chris (anak tengah, dia tidak terlalu cerdas tetapi memiliki hasrat untuk film ). Anggota terakhir keluarga itu adalah Brian - anjing yang bisa bicara dan lebih dari sekadar hewan peliharaan, ia menjaga Stewie, sementara menghirup Martinis dan memilah-milah masalah hidupnya sendiri.\"],\n" +
                "            \"poster_path\": \"/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"original_name\": \"Arrow\",\n" +
                "          \"genre_ids\": [\n" +
                "              80,\n" +
                "              18,\n" +
                "              9648,\n" +
                "              10759\n" +
                "          ],\n" +
                "          \"name\": [\"Arrow\", \"Panah\"],\n" +
                "          \"popularity\": 236.988,\n" +
                "          \"origin_country\": [\n" +
                "              \"US\"\n" +
                "          ],\n" +
                "          \"vote_count\": 2606,\n" +
                "          \"release_date\": \"2012-10-10\",\n" +
                "          \"backdrop_path\": \"/dKxkwAJfGuznW8Hu0mhaDJtna0n.jpg\",\n" +
                "          \"original_language\": \"en\",\n" +
                "          \"id\": 1412,\n" +
                "          \"vote_average\": 5.8,\n" +
                "          \"overview\": [\"Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.\", \"Panah adalah menceritakan kembali  petualangan dari legendaris DC pahlawan Green Arrow\"],\n" +
                "          \"poster_path\": \"/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"original_name\": \"Fear the Walking Dead\",\n" +
                "        \"genre_ids\": [\n" +
                "            18,\n" +
                "            27\n" +
                "        ],\n" +
                "        \"name\": [\"Fear the Walking Dead\", \"Takut Matinya Jalan\"],\n" +
                "        \"popularity\": 235.872,\n" +
                "        \"origin_country\": [\n" +
                "            \"US\"\n" +
                "        ],\n" +
                "        \"vote_count\": 1004,\n" +
                "        \"release_date\": \"2015-08-23\",\n" +
                "        \"backdrop_path\": \"/nUXzdD2Jo3wV9Q7mIZjK46Yyty4.jpg\",\n" +
                "        \"original_language\": \"en\",\n" +
                "        \"id\": 62286,\n" +
                "        \"vote_average\": 6.3,\n" +
                "        \"overview\": [\"What did the world look like as it was transforming into the horrifying apocalypse depicted in \\\"The Walking Dead\\\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.\", \"Seperti apa dunia saat berubah menjadi kiamat mengerikan yang digambarkan dalam \\\"The Walking Dead\\\"? Spin-off ini ditetapkan di Los Angeles, mengikuti karakter baru saat mereka menghadapi awal akhir dunia, akan menjawab pertanyaan itu.\"],\n" +
                "        \"poster_path\": \"/lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"original_name\": \"The Simpsons\",\n" +
                "        \"genre_ids\": [\n" +
                "            16,\n" +
                "            35\n" +
                "        ],\n" +
                "        \"name\": [\"The Simpsons\", \"Simpson\"],\n" +
                "        \"popularity\": 148.496,\n" +
                "        \"origin_country\": [\n" +
                "            \"US\"\n" +
                "        ],\n" +
                "        \"vote_count\": 2104,\n" +
                "        \"release_date\": \"1989-12-17\",\n" +
                "        \"backdrop_path\": \"/1pP0gg0iNGX06wSs19EQOvzfZIF.jpg\",\n" +
                "        \"original_language\": \"en\",\n" +
                "        \"id\": 456,\n" +
                "        \"vote_average\": 7.1,\n" +
                "        \"overview\": [\"Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.\", \"Bertempat di Springfield, kota rata-rata di Amerika, pertunjukan ini berfokus pada kejenakaan dan petualangan sehari-hari keluarga Simpson; Homer, Marge, Bart, Lisa dan Maggie, serta ribuan pemain virtual. Sejak awal, serial ini telah menjadi ikon budaya pop, menarik ratusan selebriti menjadi bintang tamu. Acara ini juga menjadi terkenal karena satirnya yang tak kenal takut terhadap kehidupan politik, media, dan Amerika secara umum.\"],\n" +
                "        \"poster_path\": \"/yTZQkSsxUFJZJe67IenRM0AEklc.jpg\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"original_name\": \"Legion\",\n" +
                "        \"id\": 67195,\n" +
                "        \"name\": [\"Legion\", \"Pasukan\"],\n" +
                "        \"popularity\": 133.79,\n" +
                "        \"vote_count\": 605,\n" +
                "        \"vote_average\": 7.6,\n" +
                "        \"release_date\": \"2017-02-08\",\n" +
                "        \"poster_path\": \"/l8paJlma8P3t73B4SPtFjr8nsWF.jpg\",\n" +
                "        \"genre_ids\": [\n" +
                "            10759,\n" +
                "            10765\n" +
                "        ],\n" +
                "        \"original_language\": \"en\",\n" +
                "        \"backdrop_path\": \"/87eP7ITTrOWvkA4EqCuoRdyjzLy.jpg\",\n" +
                "        \"overview\": [\"David Haller, AKA Legion, is a troubled young man who may be more than human. Diagnosed as schizophrenic, David has been in and out of psychiatric hospitals for years. But after a strange encounter with a fellow patient, he’s confronted with the possibility that the voices he hears and the visions he sees might be real.\", \"David Haller, Legiun AKA, adalah seorang pemuda bermasalah yang mungkin lebih dari manusia. Didiagnosis sebagai penderita skizofrenia, David telah keluar masuk rumah sakit jiwa selama bertahun-tahun. Tetapi setelah pertemuan aneh dengan sesama pasien, dia dihadapkan dengan kemungkinan bahwa suara yang dia dengar dan penglihatan yang dia lihat mungkin nyata.\"],\n" +
                "        \"origin_country\": [\n" +
                "            \"US\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"original_name\": \"Grey's Anatomy\",\n" +
                "        \"id\": 1416,\n" +
                "        \"name\": [\"Grey's Anatomy\", \"Anatomi Abu-abu\"],\n" +
                "        \"popularity\": 154.734,\n" +
                "        \"vote_count\": 994,\n" +
                "        \"vote_average\": 6.3,\n" +
                "        \"release_date\": \"2005-03-27\",\n" +
                "        \"poster_path\": \"/eqgIOObafPJitt8JNh1LuO2fvqu.jpg\",\n" +
                "        \"genre_ids\": [\n" +
                "            18\n" +
                "        ],\n" +
                "        \"original_language\": \"en\",\n" +
                "        \"backdrop_path\": \"/hF9yq8MxaTNLJITo0lwgO7eUoTx.jpg\",\n" +
                "        \"overview\": [\"Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.\", \"Ikuti kehidupan pribadi dan profesional sekelompok dokter di Rumah Sakit Gray Sloan Memorial di Seattle.\"],\n" +
                "        \"origin_country\": [\n" +
                "            \"US\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"original_name\": \"Marvel's Agents of S.H.I.E.L.D.\",\n" +
                "        \"genre_ids\": [\n" +
                "            18,\n" +
                "            10759,\n" +
                "            10765\n" +
                "        ],\n" +
                "        \"name\": [\"Marvel's Agents of S.H.I.E.L.D.\", \"Marvel - Agen T.A.M.E.N.G.\"],\n" +
                "        \"popularity\": 131.882,\n" +
                "        \"origin_country\": [\n" +
                "            \"US\"\n" +
                "        ],\n" +
                "        \"vote_count\": 1351,\n" +
                "        \"release_date\": \"2013-09-24\",\n" +
                "        \"backdrop_path\": \"/iWopHyAvuIDjGX10Yc3nn6UEebW.jpg\",\n" +
                "        \"original_language\": \"en\",\n" +
                "        \"id\": 1403,\n" +
                "        \"vote_average\": 6.8,\n" +
                "        \"overview\": [\"Agent Phil Coulson of S.H.I.E.L.D. (Strategic Homeland Intervention, Enforcement and Logistics Division) puts together a team of agents to investigate the new, the strange and the unknown around the globe, protecting the ordinary from the extraordinary.\", \"Marvel T.A.M.E.N.G. adalah serial televisi Amerika yang diciptakan oleh Joss Whedon yang berdasarkan oleh organisasi Marvel Comics dengan nama yang sama. Ini akan ditetapkan dalam Marvel Cinematic Universe, berbagi kontinuitas dengan film-film di franchise\"],\n" +
                "        \"poster_path\": \"/xjm6uVktPuKXNILwjLXwVG5d5BU.jpg\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"original_name\": \"ナルト 疾風伝\",\n" +
                "        \"id\": 31910,\n" +
                "        \"name\": [\"Naruto Shippūden\", \"Naruto Shippuden\"],\n" +
                "        \"popularity\": 131.189,\n" +
                "        \"vote_count\": 242,\n" +
                "        \"vote_average\": 7.6,\n" +
                "        \"release_date\": \"2007-02-15\",\n" +
                "        \"poster_path\": \"/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg\",\n" +
                "        \"genre_ids\": [\n" +
                "            16,\n" +
                "            35,\n" +
                "            18\n" +
                "        ],\n" +
                "        \"original_language\": \"ja\",\n" +
                "        \"backdrop_path\": \"/c14vjmndzL9tBdooGsMznMFrFLo.jpg\",\n" +
                "        \"overview\": [\"Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.\", \"Naruto Shippuuden adalah kelanjutan dari serial TV animasi asli Naruto. Kisah ini berkisah tentang Uzumaki Naruto yang lebih tua dan sedikit lebih matang dan upayanya untuk menyelamatkan temannya Uchiha Sasuke dari cengkeraman Shinobi seperti ular, Orochimaru. Setelah 2 setengah tahun, Naruto akhirnya kembali ke desanya Konoha, dan mulai mewujudkan ambisinya, meskipun itu tidak akan mudah, karena Ia telah mengumpulkan beberapa musuh (lebih berbahaya), seperti organisasi shinobi. ; Akatsuki.\"],\n" +
                "        \"origin_country\": [\n" +
                "            \"JP\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"original_name\": \"Stranger Things\",\n" +
                "        \"genre_ids\": [\n" +
                "            18,\n" +
                "            9648,\n" +
                "            10765\n" +
                "        ],\n" +
                "        \"name\": [\"Stranger Things\", \"Sesuatu yang Aneh\"],\n" +
                "        \"popularity\": 127.239,\n" +
                "        \"origin_country\": [\n" +
                "            \"US\"\n" +
                "        ],\n" +
                "        \"vote_count\": 2566,\n" +
                "        \"release_date\": \"2016-07-15\",\n" +
                "        \"backdrop_path\": \"/56v2KjBlU4XaOv9rVYEQypROD7P.jpg\",\n" +
                "        \"original_language\": \"en\",\n" +
                "        \"id\": 66732,\n" +
                "        \"vote_average\": 8.3,\n" +
                "        \"overview\": [\"When a young boy vanishes, a small town uncovers a mystery involving secret experiments, terrifying supernatural forces, and one strange little girl.\", \"Ketika seorang bocah lelaki menghilang, sebuah kota kecil mengungkap misteri yang melibatkan eksperimen rahasia, kekuatan gaib yang menakutkan, dan seorang gadis kecil yang aneh.\"],\n" +
                "        \"poster_path\": \"/esKFbCWAGyUUNshT5HE5BIpvbcL.jpg\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }"
    }
}