package ao.co.isptec.aplm.helloandroid

// Data class que encapsula a lista de palavras e calcula as estatísticas
data class PalavraBundle(val palavras: List<String>) {

    // 1. Contagem total de palavras
    val contar = palavras.size

    // 2. Comprimento médio (map cria uma lista com o tamanho de cada palavra e average() faz a média)
    val comprimentoMedio = if (palavras.isEmpty()) 0.0 else palavras.map { it.length }.average()

    // 3. A palavra mais longa (maxByOrNull procura a palavra com maior length)
    val palavraMaisLonga = palavras.maxByOrNull { it.length } ?: "Não disponível."
}
// Função de nível superior (fora da classe)
fun gerarResumo(bundle: PalavraBundle): String {
    // Usamos uma lambda { it.length > 4 } para filtrar as palavras longas
    val palavrasLongas = bundle.palavras.filter { it.length > 4 }

    // Se não houver palavras, retornamos uma mensagem simples
    if (bundle.contar == 0) {
        return "Nenhuma palavra encontrada!"
    }

    // Construímos o resumo com todas as estatísticas
    return "Palavras: ${bundle.contar}\n" +
            "Comprimento medio: ${String.format("%.2f", bundle.comprimentoMedio)}\n" +
            "Palavra mais longa: ${bundle.palavraMaisLonga}\n" +
            "Palavras longas (>4 letras): ${palavrasLongas.joinToString(", ")}"
}
