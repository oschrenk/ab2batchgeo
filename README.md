# README #

I wanted a map of all my addresses in my OSX Adress Book. 

1. Use [Export Address Book](http://www.subclassed.com/software/export_address_book/details) (Commercial, $3.99 in MacApp Store) for convenience to export address book as csv file (tab delimiter, utf-8)
2. Run `./ab2batchgeo export.txt output.txt` to aggregate work and private adresses into one address field
3. Import into [batchgeo](http://batchgeo.com/)

## Input Format ##

Header fields:

- `"Vorname"`
- `"Nachname"`
- `"Firma"`
- `"Arbeit Straße"`
- `"Arbeit Stadt"`
- `"Arbeit PLZ"`
- `"Arbeit Land"`
- `"Privat Straße"`
- `"Privat Stadt"`
- `"Privat PLZ"`
- `"Privat Land"`

Format:

- tab delimited
- fields quoted with double quotes eg. `"<entry>"`

## Output Format ##

Header fields:

- `Name`
- `Straße`
- `Stadt`
- `PLZ`

Format:
- tab delimited entries
- unquoted fields