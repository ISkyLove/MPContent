package lc.mpcontent.utils.parser;

import java.io.InputStream;

/**
 * Created by lin on 16-5-22.
 */
public interface ISAXParserXML {
    void parser(InputStream inputStream, BaseSAXHandler.OnParserFinishListen listen);
}
