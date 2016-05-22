package lc.mpcontent.utils.parser;

import java.io.InputStream;
import java.util.List;

/**
 * Created by lin on 16-5-22.
 */
public interface IDOMParserXML<T> {
    List<T> getDataList(InputStream inputStream);
}
