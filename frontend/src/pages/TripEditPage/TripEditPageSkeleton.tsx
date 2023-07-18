import { containerStyling, skeletonContainerStyling } from '@pages/TripEditPage/TripEditPage.style';

import DayLogListSkeleton from '@components/common/DayLogList/DayLogListSkeleton';
import TripInformationSkeleton from '@components/common/TripInformation/TripInformationSkeleton';

const TripEditPageSkeleton = () => {
  return (
    <section css={[containerStyling, skeletonContainerStyling]}>
      <TripInformationSkeleton />
      <DayLogListSkeleton />
    </section>
  );
};

export default TripEditPageSkeleton;
