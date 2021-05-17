Código para a aula de dataspaces da disciplina de Técnicas de Programação 2 - 2020.2

Código construído sbt-shell e posteriormente importado para o IntelliJ, de onde é executado no video.
Para rodas o programa, são necessários 3 parâmetros:
	Parâmetro 1 (args0)): nome do arquivo que contém stop words
	Parâmetro 2 (args(1)): nome do arquivo que contém com texto a ser processado
	Parâmetro 3 (args(2)): charset

O parâmetro de charset se viu necessário em virtude de alguns dos arquivos de exemplo estarem em formato ISO-8859-1

Exemplos executados do sbt shell dentro da pasta word_count:
	run data/stop_words.txt data/genesis_linha1.txt utf-8
	run data/stop_words.txt data/genesis.txt utf-8
	run data/stop_words.txt data/machado_dom_casmurro.txt iso-8859-1
	run data/stop_words.txt data/machado_memorias.txt iso-8859-1
