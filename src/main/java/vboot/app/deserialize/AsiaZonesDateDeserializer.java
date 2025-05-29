package vboot.app.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//yyyyMMddHHmmssSSSZ 格式时间解析
// Analisador de datas no formato yyyyMMddHHmmssSSSZ
@Slf4j
public class AsiaZonesDateDeserializer extends JsonDeserializer<Date> {
    private static final String DATE_PATTERN = "yyyyMMddHHmmssSSSZ";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String dateStr = p.getText();
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            log.error("时间解析失败: " + dateStr, e);
            // Falha ao analisar a data
            throw new RuntimeException("Falha ao analisar a data: " + dateStr, e);
        }
    }

}
