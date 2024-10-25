INSERT INTO SP_SENSOR(id, name, sensor_value, sensor_type) VALUES(-10, 'Temperature room 2', 21.3, 'TEMPERATURE');
INSERT INTO SP_SENSOR(id, name, sensor_value, sensor_type) VALUES(-9, 'Window 1 status room 1', 1.0, 'STATUS');
INSERT INTO SP_SENSOR(id, name, sensor_value, sensor_type) VALUES(-8, 'Window 2 status room 1', 0.0, 'STATUS');
INSERT INTO SP_SENSOR(id, name, sensor_value, sensor_type) VALUES(-7, 'Window 1 status room 2', 0.0, 'STATUS');
INSERT INTO SP_SENSOR(id, name, sensor_value, sensor_type) VALUES(-6, 'Window 2 status room 2', 0.0, 'STATUS');

INSERT INTO SP_ROOM(id, name, floor) VALUES(-10, 'Room1', 1);
INSERT INTO SP_ROOM(id, name, floor, current_temperature_id, target_temperature) VALUES(-9, 'Room2', 1, -10, 20.0);

INSERT INTO SP_WINDOW(id, window_status, name, room_id) VALUES(-10, 'OPEN', 'Window 1', -10);
INSERT INTO SP_WINDOW(id, window_status, name, room_id) VALUES(-9, 'CLOSE', 'Window 2', -10);
INSERT INTO SP_WINDOW(id, window_status, name, room_id) VALUES(-8, 'CLOSE', 'Window 1', -9);
INSERT INTO SP_WINDOW(id, window_status, name, room_id) VALUES(-7, 'OPEN', 'Window 2', -9);