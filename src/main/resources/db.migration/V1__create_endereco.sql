CREATE TABLE endereco (
                          id BIGSERIAL PRIMARY KEY,
                          logradouro VARCHAR(255) NOT NULL,
                          cep VARCHAR(20) NOT NULL,
                          numero VARCHAR(10) NOT NULL,
                          latitude DOUBLE PRECISION NOT NULL,
                          longitude DOUBLE PRECISION NOT NULL
);

INSERT INTO endereco (logradouro, cep, numero, latitude, longitude)
VALUES ('Rua Fictícia', '12345-678', '100A', -23.561684, -46.625378);
