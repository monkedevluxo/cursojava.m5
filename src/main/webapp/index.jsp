<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Wallet Digital</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
        }
        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #ffffff;
            border: none;
            padding: 10px 20px;
            border-radius: 3px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <form action="cuenta" method="post">
        <label for="numeroCuenta">Número de Cuenta:</label>
        <input type="text" id="numeroCuenta" name="numeroCuenta"><br>
        <label for="titular">Titular:</label>
        <input type="text" id="titular" name="titular"><br>
        <label for="saldo">Saldo:</label>
        <input type="text" id="saldo" name="saldo"><br>
        <input type="submit" value="Enviar">
    </form>
</body>
</html>
