create table Message
(
    id              int primary key generated always as identity,
    processed_at    timestamp not null,
    encoded_message varchar   not null,
    decoded_message varchar   not null
);