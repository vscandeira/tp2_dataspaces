# Implementação de Word Count no estilo DataSpaces
*(Código do Grupo 6 para a aula de dataspaces da disciplina de Técnicas de Programação 2 - 2020.2)*
<p>Código construído via sbt-shell e posteriormente importado para o IntelliJ, pode ser executado via terminal ou via IDE.</p>

##Parâmetros
<p>Para rodas o programa, são necessários 3 parâmetros:</p>
1. args(0): nome do arquivo que contém stop words
2. args(1): nome do arquivo que contém com texto a ser processado
3. args(2): charset

<p>O parâmetro de charset se viu necessário em virtude de alguns dos arquivos de exemplo estarem em formato ISO-8859-1</p>

##Exemplos
<p>Exemplos executados do sbt shell dentro da pasta word_count:</p>
- run data/stop_words.txt data/genesis_linha1.txt utf-8
- run data/stop_words.txt data/genesis.txt utf-8
- run data/stop_words.txt data/machado_dom_casmurro.txt iso-8859-1
- run data/stop_words.txt data/machado_memorias.txt iso-8859-1

##Apresentação
![](https://onedrive.live.com/view.aspx?resid=1221CCC649E22A70!8763&ithint=file%2Cpptx&authkey=!AIOvWdITGT2RTgc)
