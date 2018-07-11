package com.kewenc.deskmemo.util;

import java.util.ArrayList;
import java.util.List;

public class AnalysisDataUtil {
    private static final int KCTXT_MARK = 0;
    private static final int KCIMG_MARK = 1;
    private static final int KCVOI_MARK = 2;
    private static final int KCVID_MARK = 3;

    private static final String KCTXT = "<kctxt>";
    private static final String KCIMG = "<kcimg>";
    private static final String KCVOI = "<kcvoi>";
    private static final String KCVID = "<kcvid>";

    private static final String KCTXT_END = "</kctxt>";
    private static final String KCIMG_END = "</kcimg>";
    private static final String KCVOI_END = "</kcvoi>";
    private static final String KCVID_END = "</kcvid>";

    private static final int OFFSET = KCTXT.length();
    private static final int OFFSET_END = KCTXT_END.length();

    private List<Integer> indexList = new ArrayList<>();
    /**
     *  <kctxt>Hello Desk Memo !</kctxt>
     *  <kcimg>/Android/com/kewenc/deskmemo/img01</kcimg>
     *  <kctxt>Hello Desk Memo !</kctxt>
     *  <kcvoi>/Android/com/kewenc/deskmemo/voi01</kcvoi>
     *  <kcvid>/Android/com/kewenc/deskmemo/vid01</kcvid>
     */
    public List<Integer> getData(String str){
        for (int i = 0;i<str.length();i++){
            if (indexList.size() % 3 != 2 && (str.charAt(i)+"").equals("<")){
                switch (str.substring(i, i+OFFSET)){
                    case KCTXT:
                        indexList.add(i);
                        indexList.add(KCTXT_MARK);
                        i += OFFSET;
                        break;
                    case KCIMG:
                        indexList.add(i);
                        indexList.add(KCIMG_MARK);
                        i += OFFSET;
                        break;
                    case KCVOI:
                        indexList.add(i);
                        indexList.add(KCVOI_MARK);
                        i += OFFSET;
                        break;
                    case KCVID:
                        indexList.add(i);
                        indexList.add(KCVID_MARK);
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
}
