MAIN = recfm-ug.en
LATEXOPTS = -shell-escape --interaction nonstopmode -halt-on-error -file-line-error

all: ${MAIN}.pdf

${MAIN}.pdf: ${MAIN}.tex 000-pre.tex 001-title.tex 010-intro.tex \
020-spi.tex 030-s.tex 031-s-maven.tex 032-s-config.tex 033-s-gradle.tex \
040-sp.tex 041-sp-java.tex
	pdflatex ${LATEXOPTS} '$<'
	makeindex '$(basename $<).idx'
	pdflatex ${LATEXOPTS} '$<'
	pdflatex ${LATEXOPTS} '$<'

clean:
	rm -f *.aux *.idx *.ilg *.ind *.lof *.log *.lol *.lot *.out *.toc
	rm -rf _minted-*
	