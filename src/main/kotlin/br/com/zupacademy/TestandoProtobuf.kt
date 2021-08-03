package br.com.zupacademy

import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {
    val request = FuncionarioRequest.newBuilder()
        .setNome("Charles")
        .setCpf("000.000.000-00")
        .setSalario(2000.0)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
            .setLogradouro("rua Tal")
            .setCep("00.000-000")
            .setComplemento("Casa")
            .build())
        .build()

    println(request)

    request.writeTo(FileOutputStream("funcionarioRequest.bin"))

    val request2 = FuncionarioRequest.newBuilder()
        .mergeFrom(FileInputStream("funcionarioRequest.bin"))

    request2.setCargo(Cargo.GERENTE).build()

    println(request2)

}