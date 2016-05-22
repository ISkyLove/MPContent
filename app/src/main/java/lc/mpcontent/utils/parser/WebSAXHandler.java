package lc.mpcontent.utils.parser;


import org.xml.sax.Attributes;

import lc.mpcontent.bean.WebBean;
import lc.mpcontent.utils.parser.parserbean.WebsTab;

/**
 * Created by lin on 16-5-22.
 */
public class WebSAXHandler extends BaseSAXHandler<WebBean> {

    private WebBean mWebBean;

    @Override
    protected void parserElement(String tabname, String tabcontent, Attributes tabattr) {
        switch (tabname) {
            case WebsTab.WEB :
                if(mWebBean!=null) {
                    mData.add(mWebBean);
                    mWebBean = null;
                }
                break;
            case WebsTab.ID :
                mWebBean = new WebBean();
                mWebBean.setId(Integer.parseInt(tabcontent));
                break;
            case WebsTab.TITLE :
                if(mWebBean!=null){
                    mWebBean.setTitle(tabcontent);
                }
                break;
            case WebsTab.LOGO :
                if(mWebBean!=null){
                    mWebBean.setLogo(tabcontent);
                }
                break;
            case WebsTab.ICO :
                if(mWebBean!=null){
                    mWebBean.setIco(tabcontent);
                }
                break;
            case WebsTab.DEC :
                if(mWebBean!=null){
                    mWebBean.setDescription(tabcontent);
                }
                break;
            case WebsTab.URL :
                if(mWebBean!=null){
                    mWebBean.setUrl(tabcontent);
                }
                break;
        }
    }
}
