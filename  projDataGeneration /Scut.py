import itertools
from datetime import date

class Scut:
    newid = itertools.count().next
    def __init__(self, latitude, longitude, priceClass1, priceClass2, priceClass3, priceClass4, priceClass5 ) -> None:
        self._id = Scut.newid()
        self._latitude = latitude
        self._longitude = longitude
        self._instalationDate = date.today()
        self._priceClass1 = priceClass1
        self._priceClass2 = priceClass2
        self._priceClass3 = priceClass3
        self._priceClass4 = priceClass4
        self._priceClass5 = priceClass5

    @property
    def id(self):
        return self._id

    @property
    def latitude(self):
        return self._latitude

    @property
    def longitude(self):
        return self._longitude

    @property
    def instalationDate(self):
        return self._instalationDate

    @property
    def priceClass1(self):
        return self._priceClass1

    @property
    def priceClass2(self):
        return self._priceClass2

    @property
    def priceClass3(self):
        return self._priceClass3

    @property
    def priceClass4(self):
        return self._priceClass4

    @property
    def priceClass5(self):
        return self._priceClass5

    @priceClass1.setter
    def priceClass1(self, priceClass1):
        self._priceClass1 = priceClass1

    @priceClass2.setter
    def priceClass2(self, priceClass2):
        self._priceClass2 = priceClass2

    @priceClass3.setter
    def priceClass3(self, priceClass3):
        self._priceClass3 = priceClass3

    @priceClass4.setter
    def priceClass4(self, priceClass4):
        self._priceClass4 = priceClass4

    @priceClass5.setter
    def priceClass5(self, priceClass5):
        self._priceClass5 = priceClass5

    '''
    def __str__(self) -> str:
        return 

    def __repr__(self) -> str:
        return self.__str__()
    '''
