# Implementação de Word Count no estilo DataSpaces
*(Código do Grupo 6 para a aula de dataspaces da disciplina de Técnicas de Programação 2 - 2020.2)*
![](/recursos/dataspaces.png)

<p>Código construído via sbt-shell e posteriormente importado para o IntelliJ, pode ser executado via terminal ou via IDE.</p>

## Link para VideoAula do Estilo
<p>https://unbbr-my.sharepoint.com/:v:/g/personal/170157636_aluno_unb_br/EdTAkbI-YdJPuIrTK_PdEQoBLppGLMuqGdJsF2B8vtobeg?e=CNutLS</p>

<br />
## Link para Apresentação
<p>https://onedrive.live.com/view.aspx?resid=1221CCC649E22A70!8763&ithint=file%2Cpptx&authkey=!AIOvWdITGT2RTgc</p>

## Parâmetros
<p>Para rodas o programa, são necessários 3 parâmetros:</p>
1. args(0): nome do arquivo que contém stop words<br />
2. args(1): nome do arquivo que contém com texto a ser processado<br />
3. args(2): charset<br />
<br />
<p>O parâmetro de charset se viu necessário em virtude de alguns dos arquivos de exemplo estarem em formato ISO-8859-1</p>

## Exemplos
<p>Exemplos executados do sbt shell dentro da pasta word_count:</p>
* run data/stop_words.txt data/genesis_linha1.txt utf-8<br />
* run data/stop_words.txt data/genesis.txt utf-8<br />
* run data/stop_words.txt data/machado_dom_casmurro.txt iso-8859-1<br />
* run data/stop_words.txt data/machado_memorias.txt iso-8859-1<br />
