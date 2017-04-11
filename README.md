# BahasaWordnetProcessing
Bahasa Wordnet Processing - Done as a part of the AAAI paper "WWDS"

This is the raw data for the Wordnet Bahasa, a wordnet for the Malay
languages (currently Malaysian and Indonesian).

For more details see the project page at: http://sourceforge.net/p/wn-msa/

The data is released under the MIT license.

File format:

synset\tlang\tgoodness\tlemma

Synset (Synonym set) is the offset-pos from Princeton wordnet 3.0 lang:

- B (Bahasa = msa); 
- I (Indonesian = ind); 
- M (Malay = zsm)

Goodness is:

- Y = hand checked and good
- O = automatic high quality (good)
- M = automatic medium quality (ok)
- L = automatic, probably bad (low)
- X = hand checked and bad

Normal release has only Y and O.

e.g.

00015388-n	B	X	fauna

00015388-n	M	Y	haiwan

00015388-n	I	Y	hewan

Note: msa is the supertype of ind and zsm

========================================================================

Apostrophe should be (’) U+2019 as in: Côte d’Ivoire.
Technically glottal stop should be (ʼ) Letter apostrophe U+02BC.
We need to make the lookup more forgiving of this.

There are some abbreviations in use:
- yg = yang
- pd = pada

========================================================================

Def:

06822958-n	DEF	tanda koma di bawah konsonan c tanda bunyi 's'

06823760-n	DEF	dua titik di atas huruf vokal

Link : http://wn-msa.sourceforge.net/


