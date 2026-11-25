CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE canvas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    id_user INT NOT NULL,
    figuras_json TEXT,
    fecha_creacion VARCHAR(20),
    fecha_modificacion VARCHAR(20),
    num_objetos INT DEFAULT 0,
    FOREIGN KEY (id_user) REFERENCES users(id)
);