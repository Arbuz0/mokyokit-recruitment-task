SELECT
    DATE(kontakt_ts) AS data,
    SUM(CASE WHEN status = 'zainteresowany' THEN 1 ELSE 0 END) AS sukcesy,
    SUM(CASE WHEN status = 'niezainteresowany' THEN 1 ELSE 0 END) AS utraty,
    SUM(CASE WHEN status IN ('poczta_głosowa', 'nie_ma_w_domu') THEN 1 ELSE 0 END) AS do_ponowienia,
    SUM(CASE WHEN status = 'niezainteresowany' AND poprzedni_status = 'zainteresowany' THEN 1 ELSE 0 END) AS zainteresowani_utraty,
    SUM(CASE WHEN status = 'zainteresowany' AND poprzedni_status = 'niezainteresowany' THEN 1 ELSE 0 END) AS niezainteresowani_sukcesy
FROM (
    SELECT
        status,
        kontakt_ts,
        LAG(status) OVER (PARTITION BY klient_id ORDER BY kontakt_ts) AS poprzedni_status
    FROM statuses
) statuses_latest
GROUP BY DATE(kontakt_ts)
ORDER BY DATE(kontakt_ts);