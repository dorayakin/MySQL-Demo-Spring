-- V1.99__Insert_cities_dummy_data.sql
DROP FUNCTION IF EXISTS zenkakuhiragana;

DELIMITER // 

CREATE FUNCTION zenkakuhiragana(DATA TEXT CHARACTER SET utf8mb4) RETURNS TEXT CHARACTER 
SET
    utf8mb4 DETERMINISTIC BEGIN DECLARE kana1_len, 
    kana2_len INT;

DECLARE kana1_h VARCHAR(72) character set utf8mb4 DEFAULT 'ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜｦﾝｯｬｭｮｧｨｩｪｫ ｰ｡｢｣､･1234567890';

DECLARE kana1_z VARCHAR(72) character set utf8mb4 DEFAULT 'あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをんっゃゅょぁぃぅぇぉ　ー。「」、・１２３４５６７８９０';

DECLARE kana2_h VARCHAR(52) character set utf8mb4 DEFAULT 'ｶﾞｷﾞｸﾞｹﾞｺﾞｻﾞｼﾞｽﾞｾﾞｿﾞﾀﾞﾁﾞﾂﾞﾃﾞﾄﾞﾊﾞﾋﾞﾌﾞﾍﾞﾎﾞﾊﾟﾋﾟﾌﾟﾍﾟﾎﾟｳﾞ';

DECLARE kana2_z VARCHAR(26) character set utf8mb4 DEFAULT 'がぎぐげござじずぜぞだぢづでどばびぶべぼぱぴぷぺぽゔ';

SET
    kana1_len = CHAR_LENGTH(kana1_z);

SET
    kana2_len = CHAR_LENGTH(kana2_z);

WHILE kana2_len > 0 DO
SET
    data = REPLACE(
        data,
        SUBSTRING(kana2_h, kana2_len * 2 - 1, 2),
        SUBSTRING(kana2_z, kana2_len, 1)
    );

SET
    kana2_len = kana2_len - 1;

END WHILE;

WHILE kana1_len > 0 DO
SET
    data = REPLACE(
        data,
        SUBSTRING(kana1_h, kana1_len, 1),
        SUBSTRING(kana1_z, kana1_len, 1)
    );

SET
    kana1_len = kana1_len - 1;

END WHILE;

RETURN data;

END;
//
DELIMITER;

LOAD DATA LOCAL INFILE 'src\\main\\resources\\db\\csv\\cities.csv' INTO TABLE city FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' (
    @group_code,
    @prefecture,
    @city,
    @city_kana
)
SET
    prefecture_id = SUBSTRING(@group_code, 1, 2),
    code = SUBSTRING(@group_code, 3, 3),
    name = @city,
    name_kana = zenkakuhiragana(@city_kana),
    kana_initial = zenkakuhiragana(SUBSTRING(@city_kana, 1, 1));
