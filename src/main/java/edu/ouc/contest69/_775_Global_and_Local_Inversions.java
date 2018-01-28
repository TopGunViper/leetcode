package edu.ouc.contest69;

import java.util.Arrays;

import org.junit.Assert;

/**
 * @author wqx
 */
public class _775_Global_and_Local_Inversions {

    /**
     * Solution one: brute force!
     *
     * Time Limit Exceeded！！！
     *
     * @param A
     * @return
     */
    public boolean isIdealPermutation1(int[] A) {
        int localInversions = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                localInversions++;
            }
        }
        for (int i = 0; i < A.length ; i++) {
            for(int j = i + 2; j < A.length; j++){
                if(A[i] > A[j]){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Solution2:
     * We already know that the array A is permutation.
     *
     * @param A
     * @return
     */
    public boolean isIdealPermutation(int[] A) {

        boolean changePos = false;
        for (int i = 0; i < A.length ; i++) {
            if(!changePos && A[i] != i){
                if(A[i] != i+1){
                    return false;
                }
                changePos = true;
            }else if(changePos && A[i] != i-1){
                return false;
            }else {
                changePos = false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        //test case1
        _775_Global_and_Local_Inversions tester = new _775_Global_and_Local_Inversions();
        int[] A = {1, 0, 2};
        Assert.assertTrue(tester.isIdealPermutation(A));

        int[] A2 = {1, 2, 0};
        Assert.assertFalse(tester.isIdealPermutation(A2));

        int[] A3 = {1,0,2,4,3,5,6,8,7,10,9,12,11,13,14,15,17,16,18,19,20,21,23,22,24,26,25,28,27,29,30,31,33,32,34,35,
                36,37,39,38,41,40,42,44,43,46,45,48,47,49,50,52,51,53,54,56,55,57,58,60,59,61,62,64,63,66,65,67,68,69,71,70,73,72,74,75,77,76,78,80,79,82,81,84,83,85,86,88,87,89,91,90,93,92,95,94,96,97,98,99,100,102,101,103,105,104,107,106,109,108,111,110,113,112,114,115,116,117,119,118,120,121,122,124,123,125,126,127,129,128,130,132,131,133,134,136,135,137,139,138,141,140,142,143,144,145,147,146,148,149,150,151,152,154,153,155,156,158,157,160,159,161,163,162,164,165,166,167,169,168,170,171,173,172,174,175,177,176,178,179,180,181,183,182,185,184,187,186,188,190,189,191,192,194,193,195,197,196,199,198,201,200,202,204,203,205,207,206,208,209,210,211,213,212,215,214,216,217,219,218,220,221,222,223,225,224,227,226,229,228,230,232,231,234,233,236,235,237,239,238,241,240,242,243,244,245,247,246,248,249,250,252,251,254,253,255,256,258,257,260,259,261,263,262,264,265,266,267,268,269,270,272,271,273,275,274,276,278,277,280,279,281,282,284,283,286,285,287,289,288,290,292,291,293,295,294,297,296,299,298,300,301,302,303,305,304,306,307,309,308,311,310,312,314,313,316,315,318,317,320,319,322,321,323,325,324,327,326,329,328,330,332,331,334,333,335,337,336,338,340,339,342,341,343,344,345,347,346,348,350,349,351,352,353,355,354,357,356,358,359,360,362,361,364,363,366,365,367,368,369,370,371,372,374,373,376,375,378,377,379,381,380,383,382,384,386,385,388,387,390,389,392,391,394,393,395,397,396,398,399,401,400,403,402,404,405,407,406,408,409,411,410,412,414,413,415,416,417,418,420,419,421,422,423,424,425,426,428,427,430,429,431,432,433,434,435,436,438,437,439,441,440,443,442,445,444,447,446,449,448,450,451,452,453,455,454,456,458,457,459,460,462,461,464,463,466,465,467,468,469,470,471,473,472,474,475,476,477,479,478,480,481,482,484,483,485,487,486,489,488,491,490,492,494,493,496,495,497,499,498,500,501,503,502,505,504,506,508,507,509,511,510,513,512,515,514,516,517,518,520,519,521,522,524,523,526,525,528,527,529,531,530,533,532,535,534,537,536,538,540,539,541,543,542,544,545,547,546,549,548,551,550,553,552,555,554,556,558,557,559,561,560,562,564,563,565,567,566,569,568,570,572,571,573,574,575,576,577,578,580,579,582,581,583,585,584,587,586,588,590,589,592,591,594,593,595,596,597,599,598,600,602,601,603,604,605,607,606,608,610,609,611,613,612,615,614,616,618,617,620,619,621,622,624,623,626,625,628,627,629,631,630,633,632,635,634,636,637,638,639,640,642,641,643,644,645,646,647,649,648,651,650,652,654,653,655,657,656,659,658,660,662,661,664,663,665,666,667,668,669,670,671,672,673,675,674,676,678,677,680,679,681,683,682,685,684,686,687,689,688,691,690,693,692,695,694,696,698,697,699,701,700,703,702,705,704,707,706,708,709,710,712,711,713,715,714,716,717,718,719,721,720,723,722,724,726,725,728,727,729,731,730,733,732,734,735,736,737,739,738,741,740,743,742,745,744,746,748,747,750,749,751,752,754,753,756,755,757,759,758,760,762,761,763,765,764,766,767,768,770,769,771,773,772,775,774,777,776,778,779,780,781,782,784,783,786,785,788,787,790,789,792,791,793,794,796,795,797,798,799,801,800,802,804,803,806,805,808,807,810,809,811,813,812,814,815,817,816,819,818,820,822,821,824,823,826,825,827,829,828,830,832,831,833,835,834,836,837,838,839,840,842,841,843,844,845,846,847,848,850,849,851,852,853,855,854,856,857,858,860,859,861,863,862,864,865,866,867,869,868,870,871,872,873,875,874,876,877,878,880,879,882,881,884,883,885,887,886,889,888,890,891,893,892,894,895,897,896,898,899,901,900,903,902,905,904,907,906,908,909,911,910,912,913,915,914,916,917,918,919,921,920,922,924,923,925,927,926,928,929,931,930,933,932,934,936,935,937,938,940,939,941,943,942,945,944,947,946,949,948,951,950,953,952,955,954,956,957,958,960,959,962,961,964,963,966,965,967,968,969,971,970,972,974,973,976,975,978,977,979,981,980,982,983,984,986,985,987,988,989,990,992,991,993,995,994,996,997,998,999,1000,1001,1003,1002,1005,1004,1007,1006,1009,1008,1010,1012,1011,1014,1013,1016,1015,1017,1018,1019,1020,1021,1023,1022,1025,1024,1026,1028,1027,1030,1029,1031,1032,1033,1034,1036,1035,1038,1037,1040,1039,1041,1042,1043,1045,1044,1046,1047,1048,1050,1049,1051,1053,1052,1054,1056,1055,1057,1059,1058,1061,1060,1062,1063,1065,1064,1066,1067,1069,1068,1070,1071,1073,1072,1075,1074,1076,1078,1077,1080,1079,1082,1081,1083,1084,1086,1085,1087,1088,1089,1090,1091,1092,1094,1093,1096,1095,1097,1098,1100,1099,1101,1103,1102,1105,1104,1107,1106,1109,1108,1111,1110,1112,1113,1114,1115,1116,1118,1117,1119,1120,1122,1121,1124,1123,1125,1126,1127,1128,1129,1131,1130,1133,1132,1135,1134,1136,1137,1138,1139,1140,1142,1141,1143,1145,1144,1147,1146,1148,1150,1149,1151,1153,1152,1154,1156,1155,1157,1158,1160,1159,1161,1163,1162,1164,1166,1165,1168,1167,1170,1169,1172,1171,1173,1175,1174,1176,1178,1177,1180,1179,1181,1182,1183,1184,1186,1185,1188,1187,1189,1190,1191,1193,1192,1195,1194,1197,1196,1199,1198,1200,1202,1201,1203,1205,1204,1206,1207,1209,1208,1211,1210,1212,1214,1213,1216,1215,1217,1219,1218,1220,1222,1221,1223,1224,1226,1225,1227,1229,1228,1230,1231,1233,1232,1235,1234,1237,1236,1238,1240,1239,1242,1241,1243,1245,1244,1247,1246,1248,1250,1249,1251,1253,1252,1255,1254,1257,1256,1259,1258,1261,1260,1263,1262,1264,1265,1266,1268,1267,1270,1269,1271,1272,1274,1273,1276,1275,1277,1278,1279,1281,1280,1283,1282,1285,1284,1286,1287,1288,1289,1290,1291,1292,1294,1293,1295,1296,1297,1298,1300,1299,1302,1301,1304,1303,1306,1305,1308,1307,1310,1309,1311,1312,1314,1313,1316,1315,1318,1317,1319,1321,1320,1322,1323,1325,1324,1327,1326,1328,1330,1329,1332,1331,1334,1333,1335,1337,1336,1339,1338,1340,1341,1342,1344,1343,1345,1346,1347,1348,1350,1349,1352,1351,1353,1354,1355,1356,1357,1359,1358,1361,1360,1363,1362,1365,1364,1366,1368,1367,1370,1369,1371,1373,1372,1374,1375,1377,1376,1378,1379,1380,1381,1383,1382,1385,1384,1387,1386,1389,1388,1391,1390,1392,1393,1394,1396,1395,1398,1397,1399,1400,1402,1401,1404,1403,1405,1407,1406,1408,1410,1409,1412,1411,1414,1413,1415,1416,1418,1417,1419,1421,1420,1422,1423,1424,1426,1425,1428,1427,1430,1429,1431,1432,1433,1435,1434,1436,1437,1438,1439,1441,1440,1443,1442,1445,1444,1446,1448,1447,1449,1450,1452,1451,1453,1455,1454,1456,1458,1457,1459,1461,1460,1462,1464,1463,1466,1465,1467,1469,1468,1471,1470,1473,1472,1475,1474,1476,1477,1478,1479,1480,1482,1481,1484,1483,1485,1486,1487,1488,1490,1489,1492,1491,1494,1493,1496,1495,1497,1498,1499,1500,1501,1503,1502,1505,1504,1507,1506,1508,1509,1511,1510,1513,1512,1514,1516,1515,1517,1518,1519,1520,1522,1521,1524,1523,1526,1525,1527,1528,1530,1529,1532,1531,1534,1533,1536,1535,1537,1539,1538,1540,1541,1543,1542,1544,1546,1545,1548,1547,1550,1549,1552,1551,1553,1554,1555,1556,1557,1559,1558,1560,1562,1561,1563,1565,1564,1567,1566,1569,1568,1570,1571,1572,1573,1575,1574,1576,1578,1577,1579,1580,1582,1581,1584,1583,1585,1587,1586,1588,1589,1590,1591,1593,1592,1595,1594,1597,1596,1598,1600,1599,1602,1601,1604,1603,1606,1605,1608,1607,1609,1611,1610,1613,1612,1614,1615,1616,1618,1617,1620,1619,1621,1622,1623,1625,1624,1627,1626,1628,1629,1630,1631,1632,1633,1635,1634,1637,1636,1638,1640,1639,1642,1641,1644,1643,1645,1646,1648,1647,1650,1649,1652,1651,1653,1654,1655,1656,1658,1657,1659,1661,1660,1663,1662,1664,1666,1665,1668,1667,1669,1670,1672,1671,1673,1675,1674,1676,1677,1679,1678,1680,1681,1682,1683,1684,1685,1686,1687,1688,1690,1689,1691,1693,1692,1695,1694,1697,1696,1698,1699,1700,1701,1703,1702,1705,1704,1707,1706,1709,1708,1711,1710,1712,1713,1715,1714,1716,1718,1717,1720,1719,1722,1721,1724,1723,1725,1726,1727,1728,1730,1729,1731,1732,1733,1735,1734,1737,1736,1738,1740,1739,1742,1741,1743,1745,1744,1746,1747,1748,1749,1751,1750,1753,1752,1754,1755,1757,1756,1759,1758,1761,1760,1762,1764,1763,1766,1765,1768,1767,1770,1769,1772,1771,1774,1773,1775,1777,1776,1779,1778,1781,1780,1782,1784,1783,1786,1785,1787,1789,1788,1790,1792,1791,1793,1795,1794,1796,1797,1798,1800,1799,1801,1803,1802,1805,1804,1806,1808,1807,1810,1809,1811,1812,1813,1814,1815,1816,1818,1817,1819,1820,1821,1823,1822,1825,1824,1827,1826,1828,1829,1831,1830,1833,1832,1834,1836,1835,1837,1839,1838,1840,1841,1843,1842,1844,1845,1846,1847,1848,1849,1850,1852,1851,1854,1853,1856,1855,1857,1859,1858,1860,1862,1861,1864,1863,1866,1865,1867,1869,1868,1870,1871,1872,1874,1873,1875,1876,1877,1878,1880,1879,1881,1883,1882,1885,1884,1887,1886,1889,1888,1891,1890,1893,1892,1895,1894,1897,1896,1899,1898,1900,1901,1902,1903,1905,1904,1906,1907,1909,1908,1911,1910,1913,1912,1915,1914,1917,1916,1918,1919,1920,1922,1921,1924,1923,1925,1927,1926,1928,1930,1929,1931,1933,1932,1934,1936,1935,1938,1937,1940,1939,1942,1941,1944,1943,1945,1946,1948,1947,1950,1949,1951,1953,1952,1955,1954,1956,1958,1957,1960,1959,1961,1962,1963,1964,1965,1967,1966,1969,1968,1970,1971,1972,1974,1973,1975,1976,1978,1977,1979,1981,1980,1983,1982,1985,1984,1987,1986,1989,1988,1990,1991,1992,1994,1993,1996,1995,1998,1997,2000,1999,2002,2001,2004,2003,2005,2007,2006,2008,2009,2010,2012,2011,2013,2015,2014,2017,2016,2019,2018,2020,2022,2021,2023,2025,2024,2026,2027,2029,2028,2030,2031,2033,2032,2034,2036,2035,2038,2037,2039,2040,2041,2042,2044,2043,2045,2047,2046,2048,2050,2049,2052,2051,2053,2054,2056,2055,2058,2057,2060,2059,2061,2062,2064,2063,2066,2065,2067,2069,2068,2070,2071,2073,2072,2074,2075,2076,2077,2078,2079,2080,2081,2082,2083,2084,2086,2085,2087,2089,2088,2091,2090,2092,2094,2093,2095,2097,2096,2098,2099,2100,2102,2101,2104,2103,2105,2107,2106,2109,2108,2110,2111,2113,2112,2114,2115,2117,2116,2118,2119,2120,2121,2123,2122,2124,2125,2126,2127,2128,2130,2129,2131,2133,2132,2135,2134,2136,2138,2137,2139,2141,2140,2142,2144,2143,2146,2145,2147,2149,2148,2151,2150,2152,2154,2153,2156,2155,2157,2158,2160,2159,2162,2161,2164,2163,2166,2165,2167,2168,2170,2169,2172,2171,2173,2174,2176,2175,2177,2178,2180,2179,2182,2181,2184,2183,2185,2186,2188,2187,2189,2190,2192,2191,2194,2193,2195,2196,2198,2197,2199,2201,2200,2203,2202,2205,2204,2206,2208,2207,2209,2210,2212,2211,2214,2213,2215,2217,2216,2219,2218,2221,2220,2222,2223,2225,2224,2226,2228,2227,2229,2231,2230,2233,2232,2234,2236,2235,2238,2237,2240,2239,2242,2241,2243,2244,2245,2246,2248,2247,2250,2249,2251,2253,2252,2254,2256,2255,2257,2259,2258,2260,2262,2261,2264,2263,2266,2265,2268,2267,2270,2269,2271,2272,2273,2274,2275,2276,2278,2277,2279,2281,2280,2282,2283,2285,2284,2287,2286,2288,2290,2289,2291,2293,2292,2294,2296,2295,2298,2297,2299,2300,2301,2303,2302,2305,2304,2306,2308,2307,2309,2311,2310,2312,2313,2314,2316,2315,2317,2319,2318,2320,2321,2322,2324,2323,2326,2325,2327,2328,2330,2329,2332,2331,2333,2335,2334,2336,2337,2339,2338,2341,2340,2343,2342,2345,2344,2346,2348,2347,2350,2349,2351,2352,2354,2353,2355,2356,2358,2357,2360,2359,2361,2363,2362,2364,2365,2367,2366,2368,2369,2370,2372,2371,2373,2375,2374,2377,2376,2379,2378,2381,2380,2382,2383,2384,2385,2386,2388,2387,2389,2391,2390,2392,2393,2395,2394,2397,2396,2398,2399,2400,2402,2401,2403,2404,2405,2406,2408,2407,2409,2411,2410,2412,2414,2413,2416,2415,2417,2419,2418,2421,2420,2422,2423,2425,2424,2427,2426,2428,2430,2429,2431,2432,2434,2433,2436,2435,2437,2438,2440,2439,2442,2441,2444,2443,2446,2445,2447,2449,2448,2450,2452,2451,2453,2454,2456,2455,2457,2458,2460,2459,2461,2462,2463,2464,2465,2467,2466,2469,2468,2470,2472,2471,2473,2475,2474,2476,2477,2478,2480,2479,2481,2483,2482,2485,2484,2487,2486,2488,2490,2489,2491,2493,2492,2494,2495,2496,2498,2497,2500,2499,2502,2501,2503,2504,2506,2505,2508,2507,2509,2510,2512,2511,2514,2513,2515,2516,2517,2519,2518,2521,2520,2523,2522,2524,2525,2527,2526,2529,2528,2531,2530,2532,2534,2533,2536,2535,2537,2539,2538,2540,2541,2542,2543,2544,2545,2546,2548,2547,2550,2549,2551,2553,2552,2555,2554,2557,2556,2559,2558,2560,2562,2561,2563,2565,2564,2566,2567,2568,2570,2569,2571,2573,2572,2575,2574,2576,2577,2579,2578,2580,2581,2583,2582,2585,2584,2586,2587,2588,2589,2590,2591,2592,2593,2594,2595,2597,2596,2599,2598,2600,2601,2603,2602,2604,2606,2605,2608,2607,2610,2609,2611,2613,2612,2614,2615,2616,2617,2619,2618,2620,2622,2621,2624,2623,2626,2625,2627,2628,2629,2630,2632,2631,2633,2635,2634,2636,2638,2637,2639,2641,2640,2643,2642,2644,2645,2646,2647,2649,2648,2651,2650,2653,2652,2655,2654,2657,2656,2659,2658,2660,2662,2661,2663,2665,2664,2667,2666,2668,2670,2669,2671,2672,2674,2673,2675,2676,2677,2678,2679,2680,2682,2681,2684,2683,2685,2686,2688,2687,2690,2689,2691,2693,2692,2695,2694,2696,2698,2697,2699,2701,2700,2703,2702,2704,2705,2706,2707,2709,2708,2710,2711,2712,2714,2713,2715,2716,2717,2718,2720,2719,2721,2722,2724,2723,2725,2727,2726,2729,2728,2731,2730,2733,2732,2734,2736,2735,2737,2739,2738,2740,2741,2742,2744,2743,2745,2746,2747,2748,2750,2749,2751,2752,2754,2753,2755,2756,2757,2759,2758,2760,2761,2763,2762,2765,2764,2767,2766,2769,2768,2771,2770,2772,2774,2773,2776,2775,2777,2778,2779,2780,2782,2781,2783,2784,2785,2786,2788,2787,2790,2789,2791,2793,2792,2795,2794,2797,2796,2799,2798,2801,2800,2802,2803,2805,2804,2807,2806,2809,2808,2811,2810,2813,2812,2815,2814,2816,2817,2818,2819,2820,2822,2821,2824,2823,2826,2825,2827,2828,2830,2829,2831,2833,2832,2835,2834,2837,2836,2839,2838,2841,2840,2842,2843,2844,2845,2847,2846,2848,2850,2849,2852,2851,2854,2853,2856,2855,2857,2858,2859,2861,2860,2863,2862,2865,2864,2867,2866,2868,2869,2870,2872,2871,2873,2875,2874,2876,2878,2877,2880,2879,2882,2881,2884,2883,2886,2885,2888,2887,2889,2890,2891,2893,2892,2894,2895,2896,2898,2897,2899,2900,2902,2901,2903,2904,2906,2905,2908,2907,2909,2911,2910,2912,2914,2913,2915,2916,2918,2917,2920,2919,2921,2923,2922,2924,2926,2925,2928,2927,2929,2930,2931,2932,2933,2934,2935,2936,2937,2939,2938,2940,2942,2941,2944,2943,2945,2946,2948,2947,2950,2949,2952,2951,2953,2955,2954,2956,2958,2957,2959,2960,2961,2962,2964,2963,2966,2965,2968,2967,2969,2971,2970,2972,2973,2974,2976,2975,2977,2979,2978,2981,2980,2983,2982,2985,2984,2987,2986,2989,2988,2991,2990,2993,2992,2994,2996,2995,2997,2999,2998,3000,3001,3002,3004,3003,3006,3005,3007,3008,3010,3009,3012,3011,3013,3015,3014,3016,3017,3019,3018,3021,3020,3023,3022,3024,3025,3027,3026,3029,3028,3030,3032,3031,3034,3033,3035,3036,3037,3038,3040,3039,3041,3043,3042,3045,3044,3047,3046,3048,3050,3049,3051,3053,3052,3055,3054,3057,3056,3059,3058,3060,3062,3061,3064,3063,3066,3065,3067,3068,3070,3069,3071,3073,3072,3075,3074,3076,3077,3079,3078,3081,3080,3082,3084,3083,3085,3087,3086,3089,3088,3090,3091,3093,3092,3095,3094,3096,3098,3097,3099,3101,3100,3102,3104,3103,3106,3105,3108,3107,3109,3111,3110,3112,3113,3114,3115,3117,3116,3118,3120,3119,3122,3121,3124,3123,3125,3127,3126,3129,3128,3131,3130,3133,3132,3134,3136,3135,3138,3137,3140,3139,3141,3143,3142,3144,3145,3146,3147,3149,3148,3151,3150,3153,3152,3155,3154,3156,3157,3158,3160,3159,3161,3163,3162,3164,3166,3165,3168,3167,3170,3169,3172,3171,3174,3173,3175,3177,3176,3179,3178,3181,3180,3182,3183,3185,3184,3186,3187,3188,3189,3190,3191,3192,3193,3195,3194,3197,3196,3198,3199,3200,3202,3201,3203,3205,3204,3206,3208,3207,3210,3209,3212,3211,3214,3213,3215,3216,3218,3217,3219,3221,3220,3223,3222,3225,3224,3226,3227,3228,3230,3229,3231,3233,3232,3235,3234,3237,3236,3239,3238,3241,3240,3242,3243,3244,3245,3246,3248,3247,3250,3249,3251,3253,3252,3255,3254,3256,3258,3257,3260,3259,3261,3263,3262,3264,3265,3266,3267,3269,3268,3271,3270,3273,3272,3274,3276,3275,3278,3277,3279,3280,3281,3283,3282,3285,3284,3287,3286,3289,3288,3291,3290,3292,3294,3293,3296,3295,3298,3297,3299,3301,3300,3302,3304,3303,3306,3305,3308,3307,3310,3309,3311,3313,3312,3314,3315,3316,3318,3317,3320,3319,3321,3323,3322,3325,3324,3326,3328,3327,3330,3329,3331,3333,3332,3334,3335,3337,3336,3339,3338,3340,3342,3341,3343,3344,3346,3345,3348,3347,3350,3349,3352,3351,3354,3353,3355,3356,3358,3357,3359,3361,3360,3362,3363,3365,3364,3366,3368,3367,3370,3369,3371,3373,3372,3375,3374,3377,3376,3379,3378,3380,3382,3381,3383,3384,3386,3385,3387,3389,3388,3390,3392,3391,3393,3395,3394,3396,3398,3397,3400,3399,3401,3402,3403,3405,3404,3406,3408,3407,3410,3409,3411,3413,3412,3414,3415,3417,3416,3418,3420,3419,3421,3422,3423,3424,3426,3425,3427,3429,3428,3430,3432,3431,3433,3435,3434,3437,3436,3438,3439,3440,3442,3441,3444,3443,3446,3445,3448,3447,3450,3449,3452,3451,3453,3454,3455,3456,3458,3457,3460,3459,3461,3463,3462,3465,3464,3466,3468,3467,3470,3469,3472,3471,3473,3474,3475,3476,3478,3477,3480,3479,3481,3482,3484,3483,3486,3485,3488,3487,3490,3489,3491,3493,3492,3494,3495,3497,3496,3498,3499,3501,3500,3503,3502,3504,3505,3506,3507,3509,3508,3510,3511,3513,3512,3514,3516,3515,3518,3517,3519,3520,3521,3522,3523,3525,3524,3526,3527,3529,3528,3531,3530,3532,3533,3534,3535,3537,3536,3538,3540,3539,3542,3541,3543,3544,3545,3547,3546,3548,3549,3551,3550,3552,3553,3555,3554,3556,3557,3559,3558,3561,3560,3563,3562,3565,3564,3567,3566,3568,3569,3571,3570,3572,3574,3573,3576,3575,3578,3577,3579,3581,3580,3583,3582,3584,3586,3585,3587,3589,3588,3590,3591,3593,3592,3595,3594,3596,3598,3597,3599,3601,3600,3603,3602,3605,3604,3607,3606,3608,3610,3609,3611,3613,3612,3614,3615,3617,3616,3618,3619,3620,3621,3623,3622,3624,3625,3626,3628,3627,3630,3629,3632,3631,3633,3634,3635,3637,3636,3639,3638,3641,3640,3642,3643,3645,3644,3647,3646,3648,3650,3649,3652,3651,3653,3655,3654,3656,3658,3657,3659,3661,3660,3663,3662,3665,3664,3666,3668,3667,3669,3670,3671,3673,3672,3674,3675,3677,3676,3679,3678,3680,3682,3681,3683,3685,3684,3686,3687,3688,3690,3689,3692,3691,3693,3694,3695,3697,3696,3699,3698,3701,3700,3703,3702,3704,3705,3707,3706,3708,3709,3711,3710,3713,3712,3715,3714,3716,3718,3717,3719,3720,3721,3722,3724,3723,3725,3727,3726,3729,3728,3730,3732,3731,3734,3733,3735,3737,3736,3738,3740,3739,3742,3741,3743,3745,3744,3746,3748,3747,3750,3749,3752,3751,3754,3753,3756,3755,3757,3759,3758,3760,3761,3763,3762,3765,3764,3767,3766,3769,3768,3770,3771,3773,3772,3774,3776,3775,3777,3779,3778,3781,3780,3783,3782,3784,3786,3785,3788,3787,3790,3789,3792,3791,3794,3793,3795,3797,3796,3798,3800,3799,3801,3803,3802,3805,3804,3807,3806,3808,3810,3809,3811,3812,3813,3814,3815,3816,3818,3817,3820,3819,3822,3821,3823,3824,3825,3826,3828,3827,3830,3829,3831,3833,3832,3834,3836,3835,3837,3839,3838,3840,3842,3841,3844,3843,3846,3845,3847,3849,3848,3850,3852,3851,3854,3853,3856,3855,3858,3857,3859,3861,3860,3862,3864,3863,3866,3865,3868,3867,3869,3870,3871,3872,3873,3874,3876,3875,3877,3878,3880,3879,3881,3883,3882,3884,3886,3885,3887,3888,3890,3889,3891,3893,3892,3894,3896,3895,3897,3899,3898,3900,3901,3903,3902,3904,3905,3906,3907,3908,3910,3909,3911,3912,3913,3915,3914,3916,3917,3919,3918,3920,3921,3922,3923,3924,3925,3926,3927,3928,3929,3930,3932,3931,3934,3933,3935,3937,3936,3938,3940,3939,3941,3942,3943,3945,3944,3947,3946,3948,3949,3951,3950,3952,3954,3953,3955,3957,3956,3959,3958,3960,3961,3963,3962,3965,3964,3966,3967,3969,3968,3970,3972,3971,3973,3975,3974,3976,3977,3979,3978,3981,3980,3982,3983,3985,3984,3987,3986,3988,3989,3991,3990,3993,3992,3994,3996,3995,3997,3998,4000,3999,4001,4003,4002,4004,4005,4007,4006,4008,4010,4009,4011,4012,4014,4013,4015,4017,4016,4018,4020,4019,4022,4021,4023,4024,4025,4026,4027,4028,4029,4030,4032,4031,4034,4033,4035,4036,4038,4037,4040,4039,4042,4041,4044,4043,4046,4045,4047,4049,4048,4051,4050,4053,4052,4054,4055,4056,4057,4059,4058,4060,4062,4061,4064,4063,4065,4066,4068,4067,4070,4069,4071,4073,4072,4075,4074,4076,4077,4079,4078,4081,4080,4083,4082,4084,4085,4086,4088,4087,4090,4089,4091,4093,4092,4095,4094,4096,4098,4097,4099,4101,4100,4102,4104,4103,4106,4105,4108,4107,4109,4110,4111,4112,4114,4113,4115,4117,4116,4118,4120,4119,4122,4121,4123,4125,4124,4127,4126,4129,4128,4131,4130,4132,4134,4133,4136,4135,4138,4137,4139,4141,4140,4142,4144,4143,4146,4145,4147,4149,4148,4150,4152,4151,4153,4154,4156,4155,4158,4157,4159,4160,4162,4161,4164,4163,4166,4165,4168,4167,4169,4170,4171,4172,4174,4173,4175,4177,4176,4179,4178,4180,4181,4183,4182,4185,4184,4187,4186,4189,4188,4190,4191,4192,4194,4193,4195,4196,4197,4199,4198,4201,4200,4202,4204,4203,4206,4205,4207,4208,4210,4209,4212,4211,4214,4213,4216,4215,4217,4218,4220,4219,4221,4222,4224,4223,4225,4226,4227,4229,4228,4230,4232,4231,4233,4235,4234,4236,4238,4237,4239,4241,4240,4242,4244,4243,4245,4247,4246,4248,4250,4249,4252,4251,4254,4253,4256,4255,4258,4257,4260,4259,4262,4261,4263,4264,4266,4265,4267,4269,4268,4271,4270,4272,4274,4273,4275,4276,4278,4277,4279,4280,4282,4281,4284,4283,4285,4287,4286,4289,4288,4290,4292,4291,4294,4293,4296,4295,4298,4297,4299,4300,4302,4301,4304,4303,4305,4307,4306,4309,4308,4310,4312,4311,4313,4314,4315,4316,4318,4317,4319,4321,4320,4323,4322,4325,4324,4326,4328,4327,4330,4329,4331,4333,4332,4334,4336,4335,4337,4339,4338,4341,4340,4342,4343,4344,4346,4345,4347,4348,4350,4349,4352,4351,4354,4353,4355,4356,4358,4357,4359,4361,4360,4363,4362,4365,4364,4367,4366,4369,4368,4371,4370,4373,4372,4374,4375,4377,4376,4379,4378,4381,4380,4382,4384,4383,4385,4387,4386,4389,4388,4391,4390,4392,4394,4393,4395,4396,4398,4397,4400,4399,4401,4403,4402,4404,4406,4405,4407,4408,4410,4409,4412,4411,4413,4414,4416,4415,4417,4419,4418,4420,4421,4423,4422,4425,4424,4426,4427,4428,4430,4429,4432,4431,4434,4433,4436,4435,4437,4438,4439,4440,4441,4442,4444,4443,4445,4446,4447,4449,4448,4450,4451,4453,4452,4455,4454,4456,4458,4457,4459,4461,4460,4462,4463,4464,4465,4467,4466,4469,4468,4471,4470,4473,4472,4474,4476,4475,4477,4478,4480,4479,4481,4482,4483,4485,4484,4487,4486,4488,4489,4491,4490,4493,4492,4495,4494,4497,4496,4499,4498,4501,4500,4503,4502,4504,4505,4507,4506,4508,4510,4509,4511,4513,4512,4514,4516,4515,4517,4519,4518,4520,4522,4521,4524,4523,4526,4525,4528,4527,4530,4529,4532,4531,4534,4533,4535,4537,4536,4539,4538,4541,4540,4542,4543,4545,4544,4546,4548,4547,4550,4549,4552,4551,4554,4553,4556,4555,4557,4558,4560,4559,4561,4562,4563,4565,4564,4566,4567,4568,4570,4569,4572,4571,4573,4575,4574,4576,4578,4577,4580,4579,4581,4583,4582,4584,4585,4587,4586,4588,4589,4591,4590,4592,4593,4595,4594,4597,4596,4599,4598,4601,4600,4602,4603,4604,4606,4605,4607,4608,4609,4611,4610,4613,4612,4614,4615,4616,4617,4619,4618,4621,4620,4622,4624,4623,4626,4625,4627,4628,4629,4630,4632,4631,4633,4634,4635,4637,4636,4638,4639,4641,4640,4642,4644,4643,4645,4646,4648,4647,4649,4650,4652,4651,4654,4653,4656,4655,4658,4657,4660,4659,4661,4663,4662,4665,4664,4666,4667,4668,4670,4669,4671,4673,4672,4675,4674,4677,4676,4679,4678,4681,4680,4683,4682,4684,4685,4686,4688,4687,4690,4689,4692,4691,4693,4694,4695,4696,4698,4697,4700,4699,4701,4703,4702,4704,4706,4705,4707,4709,4708,4710,4712,4711,4714,4713,4715,4717,4716,4718,4719,4721,4720,4722,4723,4724,4725,4727,4726,4729,4728,4731,4730,4733,4732,4734,4735,4737,4736,4739,4738,4740,4742,4741,4744,4743,4746,4745,4748,4747,4749,4751,4750,4753,4752,4754,4755,4756,4757,4759,4758,4760,4762,4761,4764,4763,4765,4767,4766,4769,4768,4771,4770,4772,4773,4775,4774,4777,4776,4779,4778,4780,4782,4781,4784,4783,4786,4785,4788,4787,4789,4791,4790,4793,4792,4794,4795,4797,4796,4799,4798,4800,4802,4801,4804,4803,4805,4807,4806,4808,4810,4809,4812,4811,4814,4813,4816,4815,4818,4817,4820,4819,4821,4822,4824,4823,4826,4825,4828,4827,4830,4829,4831,4833,4832,4834,4836,4835,4837,4838,4839,4840,4842,4841,4843,4844,4846,4845,4847,4849,4848,4851,4850,4853,4852,4854,4855,4856,4858,4857,4860,4859,4862,4861,4863,4865,4864,4867,4866,4868,4869,4871,4870,4873,4872,4875,4874,4877,4876,4879,4878,4880,4882,4881,4883,4885,4884,4886,4888,4887,4890,4889,4891,4892,4893,4895,4894,4897,4896,4898,4900,4899,4902,4901,4903,4904,4906,4905,4907,4908,4909,4911,4910,4912,4913,4914,4915,4917,4916,4918,4920,4919,4922,4921,4924,4923,4925,4927,4926,4928,4930,4929,4932,4931,4933,4935,4934,4937,4936,4938,4939,4940,4942,4941,4944,4943,4946,4945,4948,4947,4949,4951,4950,4953,4952,4955,4954,4957,4956,4959,4958,4960,4961,4963,4962,4964,4965,4967,4966,4969,4968,4970,4971,4973,4972,4974,4975,4977,4976,4978,4980,4979,4981,4982,4983,4985,4984,4986,4988,4987,4989,4990,4992,4991,4993,4995,4994,4996,4998,4997,4999};
        Assert.assertTrue(tester.isIdealPermutation(A3));

        int[] A4 = {2, 0, 1};
        Assert.assertFalse(tester.isIdealPermutation(A4));

    }

}
