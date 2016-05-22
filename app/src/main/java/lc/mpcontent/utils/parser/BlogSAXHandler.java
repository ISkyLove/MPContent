package lc.mpcontent.utils.parser;

import org.xml.sax.Attributes;

import lc.mpcontent.bean.BlogBean;
import lc.mpcontent.utils.parser.parserbean.BlogsTab;

/**
 * Created by lin on 16-5-22.
 */
public class BlogSAXHandler extends BaseSAXHandler<BlogBean> {

    BlogBean mBlogBean;

    @Override
    protected void parserElement(String tabname, String tabcontent, Attributes tabattr) {
        switch (tabname) {
            case BlogsTab.BLOG:
                if (mBlogBean != null) {
                    mData.add(mBlogBean);
                    mBlogBean = null;
                }
                break;
            case BlogsTab.ID:
                mBlogBean = new BlogBean();
                mBlogBean.setId(Integer.parseInt(tabcontent));
                break;
            case BlogsTab.TITLE:
                if(mBlogBean!=null){
                    mBlogBean.setTitle(tabcontent);
                }
                break;
            case BlogsTab.URL:
                if(mBlogBean!=null){
                    mBlogBean.setUrl(tabcontent);
                }
                break;
            case BlogsTab.AUTHOR:
                if(mBlogBean!=null){
                    mBlogBean.setAuthor(tabcontent);
                }
                break;
            case BlogsTab.TABS:
                if(mBlogBean!=null){
                    mBlogBean.setTabs(tabcontent);
                }
                break;
        }
    }
}
