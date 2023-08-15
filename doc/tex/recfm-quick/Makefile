MAIN = recfm-quick-reference
LATEXOPTS = -shell-escape --interaction nonstopmode -halt-on-error -file-line-error

all: ${MAIN}.pdf

${MAIN}.pdf: ${MAIN}.tex 000-pre.tex 010-plugin.tex 020-config.tex
	pdflatex ${LATEXOPTS} '$<'
	pdflatex ${LATEXOPTS} '$<'

clean:
	rm -f *.aux *.idx *.ilg *.ind *.lof *.log *.lol *.lot *.out *.toc
	rm -rf _minted-*
	