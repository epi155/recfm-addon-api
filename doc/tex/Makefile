SUBDIRS := $(wildcard */.)

all: $(SUBDIRS)
$(SUBDIRS):
	$(MAKE) -C $@

clean:
	for dir in $(SUBDIRS); do \
	$(MAKE) -C $$dir clean; \
	done

sync:
	rsync -c recfm-quick/recfm-quick-reference.pdf ../recfm-quick-reference.pdf 
	rsync -c recfm-ug-en/recfm-ug.en.pdf ../recfm-ug.en.pdf 
	rsync -c recfm-ug-it/recfm-ug.it.pdf ../recfm-ug.it.pdf 


.PHONY: all $(SUBDIRS)
