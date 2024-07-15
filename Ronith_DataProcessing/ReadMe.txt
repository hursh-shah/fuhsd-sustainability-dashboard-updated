Code/Script:
I didn't automate every single part of it b/c we won't be using the huge table forever, and it was just a one time thing to get the data, after which we only need to update it (using some other program), which means we don't process the table again (no point in doing so, as we already extracted data). It generates the CSV files without the dates matched, i.e. the really long csv file, and points out a few errors, if any, in linkage. I'd then manually just match the rows and group them by date, and then use excel to do some of the calculations.

I've also added another piece of code called TextFormat.java. Its function is to format and clean the data, while getting rid of any weird symbols, etc. It's not fully complete as I added/deleted a bunch of the .replace functions for the strings. Also some of what I did was just manual as some of the replacements were a one time thing or I couldn't find the ASCII keys for the weird characters. 

The processed (cleaned) txt files are also added in the github, as well as the pdf that Mr. Silviera sent me. You can use the Entry class to error check by printing some of its variables out.

If you need to, I can explain exactly what I did on a Zoom call. 
