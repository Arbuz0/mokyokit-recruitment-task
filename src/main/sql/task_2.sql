SELECT
    klient_id,
    status
FROM
    processed_statuses
WHERE
    klient_id IN (
        SELECT
            klient_id
        FROM
            statuses
        GROUP BY
            klient_id
        HAVING
            Count(*) > 3
    )
    AND (klient_id, kontakt_ts) IN (
        SELECT
            klient_id,
            MAX(kontakt_ts)
        FROM
            statuses
        GROUP BY
            klient_id
    )