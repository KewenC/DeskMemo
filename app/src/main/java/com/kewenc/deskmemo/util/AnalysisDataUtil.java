/*
 * Copyright (c) 18-7-12 下午10:50 Author@KewenC
 */

package com.kewenc.deskmemo.util;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/*
 *  <kctxt>Hello Desk Memo !</kctxt>
 *  <kcimg>/Android/com/kewenc/deskmemo/img01</kcimg>
 *  <kctxt>Hello Desk Memo !</kctxt>
 *  <kcvoi>/Android/com/kewenc/deskmemo/voi01</kcvoi>
 *  <kcvid>/Android/com/kewenc/deskmemo/vid01</kcvid>
 */
public class AnalysisDataUtil {
    public static final int KCTXT_MARK = 0;
    public static final int KCIMG_MARK = 1;
    public static final int KCVOI_MARK = 2;
    public static final int KCVID_MARK = 3;

    private static final String KCTXT = "<kctxt>";
    private static final String KCIMG = "<kcimg>";
    private static final String KCVOI = "<kcvoi>";
    private static final String KCVID = "<kcvid>";

    public static final String[] PRE_Mark = {KCTXT, KCIMG, KCVOI, KCVID};

    private static final String KCTXT_END = "</kctxt>";
    private static final String KCIMG_END = "</kcimg>";
    private static final String KCVOI_END = "</kcvoi>";
    private static final String KCVID_END = "</kcvid>";

    public static final String[] LAT_Mark = {KCTXT_END, KCIMG_END, KCVOI_END, KCVID_END};

    private static final int OFFSET = KCTXT.length();
    private static final int OFFSET_END = KCTXT_END.length();

    //indexList.get(i)=类型  indexList.get(i+1)=数据头  indexList.get(i+2)=数据尾
    private List<Integer> indexList = new ArrayList<>();

    /**
     * 解析数据
     * @param str 数据源
     * @return 分解的数据
     */
    public List<Integer> getData(String str){
        for (int i = 0;i<str.length();i++){
            if (indexList.size() % 3 != 2 && (str.charAt(i)+"").equals("<")){
                switch (str.substring(i, i+OFFSET)){
                    case KCTXT:
                        indexList.add(KCTXT_MARK);
                        indexList.add(i);
                        i += OFFSET;
                        break;
                    case KCIMG:
                        indexList.add(KCIMG_MARK);
                        indexList.add(i);
                        i += OFFSET;
                        break;
                    case KCVOI:
                        indexList.add(KCVOI_MARK);
                        indexList.add(i);
                        i += OFFSET;
                        break;
                    case KCVID:
                        indexList.add(KCVID_MARK);
                        indexList.add(i);
                        i += OFFSET;
                        break;
                }
            }
            if (indexList.size() % 3 == 2 && (str.charAt(i)+"").equals("<")){
                switch (str.substring(i, i+OFFSET_END)){
                    case KCTXT_END:
                        indexList.add(i);
                        i += OFFSET;
                        break;
                    case KCIMG_END:
                        indexList.add(i);
                        i += OFFSET;
                        break;
                    case KCVOI_END:
                        indexList.add(i);
                        i += OFFSET;
                        break;
                    case KCVID_END:
                        indexList.add(i);
                        i += OFFSET;
                        break;
                }
            }
        }
        return indexList;
    }

    /**
     * 打包数据
     * @param data
     * @param dataType
     * @return
     */
    public String setData(List<String> data, List<Integer> dataType) {
        String str = "";
        for (int i = 0; i<data.size(); i++){
            str += PRE_Mark[dataType.get(i)]+data.get(i)+LAT_Mark[dataType.get(i)];
        }
        return str;
    }
}
